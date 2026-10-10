# Docker

Build the runtime image:

```bash
docker build -t open-consortium:local .
```

Run locally:

```bash
docker compose up --build consortium-core
```

Run the full Maven verification inside Docker:

```bash
docker build --target test -t open-consortium:test .
```

or:

```bash
docker compose --profile test build tests
```
