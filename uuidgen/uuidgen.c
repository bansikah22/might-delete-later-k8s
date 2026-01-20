// uuidgen.c - Simple RFC 4122 UUID v4 generator for Linux
//
// Build:
//   cc -O2 -Wall -Wextra -o uuidgen uuidgen.c
//
// Usage:
//   ./uuidgen            # prints one UUID
//   ./uuidgen 5          # prints 5 UUIDs
//
// Notes:
// - Uses /dev/urandom for cryptographically secure random bytes.
// - Sets correct version (4) and variant (RFC 4122) bits.
// - Outputs lowercase hex with hyphens: 8-4-4-4-12 (36 chars).

#include <errno.h>
#include <fcntl.h>
#include <stdint.h>
#include <stdio.h>

// Fallback for O_CLOEXEC if not defined
#ifndef O_CLOEXEC
#define O_CLOEXEC 0
#endif
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define UUID_STR_LEN 36

static int read_full(int fd, void *buf, size_t len) {
    uint8_t *p = (uint8_t *)buf;
    size_t total = 0;
    while (total < len) {
        ssize_t n = read(fd, p + total, len - total);
        if (n < 0) {
            if (errno == EINTR)
                continue;
            return -1;
        }
        if (n == 0) {
            // Should not happen for urandom, but guard anyway
            return -1;
        }
        total += (size_t)n;
    }
    return 0;
}

static int get_random_bytes(uint8_t *out, size_t len) {
    int fd = open("/dev/urandom", O_RDONLY | O_CLOEXEC);
    if (fd < 0) {
        return -1;
    }
    int rc = read_full(fd, out, len);
    int saved = errno;
    close(fd);
    errno = saved;
    return rc;
}

// Generate a UUIDv4 string into out (must have space for 37 bytes including NUL)
// Returns 0 on success, -1 on failure.
int uuidv4(char out[UUID_STR_LEN + 1]) {
    uint8_t b[16];
    if (get_random_bytes(b, sizeof b) != 0) {
        return -1;
    }

    // Set version to 4 => high 4 bits of byte 6 to 0100
    b[6] = (uint8_t)((b[6] & 0x0F) | 0x40);
    // Set variant to RFC 4122 => two most significant bits of byte 8 to 10
    b[8] = (uint8_t)((b[8] & 0x3F) | 0x80);

    // Format: 8-4-4-4-12
    // positions of hyphens after chars 8, 13, 18, 23
    static const char *hex = "0123456789abcdef";
    char *p = out;
    int i;
    for (i = 0; i < 16; ++i) {
        *p++ = hex[(b[i] >> 4) & 0xF];
        *p++ = hex[b[i] & 0xF];
        if (i == 3 || i == 5 || i == 7 || i == 9) {
            *p++ = '-';
        }
    }
    *p = '\0';
    return 0;
}

static void usage(const char *prog) {
    fprintf(stderr, "Usage: %s [count]\n", prog);
}

int main(int argc, char **argv) {
    long count = 1;
    if (argc >= 2) {
        char *end = NULL;
        count = strtol(argv[1], &end, 10);
        if (end == argv[1] || *end != '\0' || count <= 0) {
            usage(argv[0]);
            return 2;
        }
    }

    char buf[UUID_STR_LEN + 1];
    for (long i = 0; i < count; ++i) {
        if (uuidv4(buf) != 0) {
            fprintf(stderr, "Failed to generate UUID: %s\n", strerror(errno));
            return 1;
        }
        puts(buf);
    }
    return 0;
}
