# unreal-repo

## Features
1. Send events into kafka when `employee` table changes.
2. Logging kafka events into `kafka-consumer-service`.

## How to run
Make sure that you have [Docker](https://www.docker.com/) installed and running on your machine.

1. Start up all the containers by running docker compose up.
    ```
    $ docker-compose up -d
    ``` 

2. Open `kafka-consumer-service` container logs to see all logged messages.
