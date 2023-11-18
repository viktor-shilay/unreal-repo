# unreal-repo

## Features
1. Send events into kafka when `employee` table changes.
2. Logging kafka events into `kafka-consumer-service`.
3. Join two tables (employee:cars - 1:n) using kafka-streams and save into Elastic Search
4. Get all employees from Elastic Search.

## How to run
Make sure that you have [Docker](https://www.docker.com/) installed and running on your machine.

1. Start up all the containers by running docker compose up.
    ```
    $ docker-compose up -d
    ``` 

2. Open `kafka-consumer-service` container logs to see all logged messages.

3. Run SQL query, for example:
   ```
   INSERT INTO department.employees
   VALUES (6, 'v_shilay666', 'Viktor', 'Shilay', '1996-01-22', 'UNEMPLOYED');
   INSERT INTO department.cars
   VALUES (11, 'BMW', '5 Series (G30/G31) 530i', '2017', 'Petrol', 'Silver', 39000.0, 6);
   ``` 
4. Wait a little while `kafka-streams-service` finishes processing messages from kafka-topics (it takes about a minute).

5. To get all employees from ES send HTTP request to

   `GET http://localhost:8081/employees`

   and you'll see response:

       {
            "id": 6,
            "username": "v_shilay666",
            "firstname": "Viktor",
            "lastname": "Shilay",
            "birth_date": "1996-01-22",
            "role": "UNEMPLOYED",
            "cars": [
                {
                    "id": 11,
                    "brand": "BMW",
                    "model": "5 Series (G30/G31) 530i",
                    "manufacture_year": "2017",
                    "engine_type": "Petrol",
                    "color": "Silver",
                    "price": 39000.0,
                    "employee_id": 6
                }
           ]
       }


