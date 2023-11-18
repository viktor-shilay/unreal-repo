# unreal-repo

## Technical requirements
1. Create docker compose with postgres container. When postgres container starts, a script is executed to create the department schema and the `employees` table. Insert some records into `employees` table.
2. Send events into kafka-topic when `employees` table changes.
3. Initialize debezium-connector using terraform.
4. Create `kafka-consumer-service` that reads events from employees-topic and logs them to the console. (Read only kafka-key, not the whole message).
5. Create `cars` table in addition to `employees` table. (employee:cars - 1:n). When records are inserted into these two tables, messages are sent automatically to the relevant kafka-topics. Create `kafka-stream-service` that reads these two topics, join them and save aggregated message to the Elastic Search index. 
6. Create `elastic-search-service` that has endpoint to get all employees.

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


