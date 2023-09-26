# unreal-repo

## Features
1. Send events into kafka when `employee` table changes.
2. Logging kafka events into application console.

## How to run
Make sure that you have [Docker](https://www.docker.com/) installed and running on your machine.

1. Start up all the containers by running docker compose up.
    ```
    $ docker-compose up -d
    ``` 
2. Once all the containers are initialized, run http-request `unreal-kafka-connector.http` to configure Debezium connector.

3. Open `unreal-repo-app` container logs to see all logged messages.
