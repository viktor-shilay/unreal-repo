# unreal-repo

## Features
1. Send events into kafka when `employee` table changes.

## How to run
Make sure that you have [Docker](https://www.docker.com/) installed and running on your machine.

1. Start up all the containers by running docker compose up.
    ```
    $ docker-compose up -d
    ``` 
2. Once all the containers are initialized, run http-request `unreal-kafka-connector.http` to configure Debezium connector.

3. Go to `http://localhost:9000/` and you'll see topic `unreal-topic.department.employees` with all the messages.
