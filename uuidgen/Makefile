# Makefile for uuidgen (C)

CC ?= cc
CFLAGS ?= -O2 -Wall -Wextra -pedantic -std=c11
LDFLAGS ?=

SRC := uuidgen.c
BIN := uuidgen

.PHONY: all build run clean format

all: build

build: $(BIN)

$(BIN): $(SRC)
	$(CC) $(CFLAGS) -o $@ $^ $(LDFLAGS)

run: build
	./$(BIN)

# Run with a count argument, e.g., make run-count N=5
run-count: build
	./$(BIN) $(N)

clean:
	rm -f $(BIN)

# Optional code formatting using clang-format if available
format:
	@if command -v clang-format >/dev/null 2>&1; then \
	  clang-format -i $(SRC); \
	else \
	  echo "clang-format not found; skipping"; \
	fi
