# An API

This project is mean to be a small API to work as a 101 for me to learn clojure by doing.

## Installation

Download from http://example.com/FIXME.

## Usage

Run the database via

```bash 
docker compose up
```

Once database is up, run the initialization scripts.

- `db/schema.sql`: Create the database schema 
- `db/data.sql`: Feed with some example data

### Running it with lein

```bash
lein ring server-headless
```

### Running it from a jar file

```bash
## Create the jar with
lein uberjar
## Run it
java -jar target/uberjar/tutorial-0.1.0-SNAPSHOT-standalone.jar
```

## License

[See licence here](LICENSE)
