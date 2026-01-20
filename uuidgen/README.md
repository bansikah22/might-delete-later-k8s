# uuidgen (C)

A minimal, self-contained UUID version 4 (random) generator in C for Linux systems. It reads entropy from `/dev/urandom`, sets the correct RFC 4122 version and variant bits, and prints UUIDs in the standard 8-4-4-4-12 lowercase hex format.

## Features
- RFC 4122-compliant UUIDv4
- Uses `/dev/urandom` for cryptographically secure random bytes
- Simple CLI: output one or multiple UUIDs
- Single-file implementation for quick learning and portability within Unix-like systems

## Build

Using Make (recommended):

```sh
make
```

This builds the `uuidgen` binary using the provided Makefile.

Direct compile with `cc`:

```sh
cc -O2 -Wall -Wextra -o uuidgen uuidgen.c
```

## Usage

Using Make:

```sh
make run
make run-count N=5
```

Direct execution:

Print a single UUID:

```sh
./uuidgen
```

Print multiple UUIDs (e.g., 5):

```sh
./uuidgen 5
```

Example output:

```
3f0a0b2e-8d21-42a8-9c4f-7f6b1d2c3e4f
b9e1c2d3-4a5b-4c6d-8e9f-0a1b2c3d4e5f
...
```

## Implementation Details
- Entropy: Reads 16 bytes from `/dev/urandom`.
- Version: Sets the high 4 bits of byte 6 to `0100` (version 4).
- Variant: Sets the two most significant bits of byte 8 to `10` (RFC 4122 variant).
- Formatting: Lowercase hex with hyphens at positions 8, 13, 18, and 23 for a 36-character string.

## Public API (if reused as a library)
Although this project is a single CLI program, the generator function is separated so you can reuse it:

```
int uuidv4(char out[36 + 1]);
```

- `out` must point to a buffer of at least 37 bytes (36 chars plus NUL terminator).
- Returns `0` on success; `-1` on failure (e.g., cannot read from `/dev/urandom`).

## Error Handling
- If `/dev/urandom` cannot be opened or read, the program prints an error message to stderr and exits with a non-zero status.
- The CLI validates the optional `count` argument and exits with code `2` for invalid input.

## Testing and Validation
- Basic format check (shell):

```sh
./uuidgen | grep -E '^[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$'
```

- Generate many UUIDs and ensure line count matches:

```sh
./uuidgen 10000 | wc -l
```

- Sample uniqueness sanity check (not a proof of uniqueness):

```sh
./uuidgen 100000 | sort | uniq -d | wc -l    # Expect 0
```

## Portability Notes
- Linux/macOS: Works on systems that provide `/dev/urandom` (most Unix-like OSes). On macOS, use `clang` instead of `cc` if preferred.
- Windows: `/dev/urandom` is not available. For Windows support, replace the entropy source with BCryptGenRandom or use UuidCreate.

## Security Considerations
- `/dev/urandom` is a cryptographically secure PRNG on modern Unix-like systems and is appropriate for generating UUIDv4 values.
- This implementation does not attempt to be a general-purpose CSPRNG; it only reads the required bytes per UUID.

## License
This project is provided for learning purposes. You may use and modify it freely. If you need an explicit license, consider adding MIT or BSD-2-Clause here.
