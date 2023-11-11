## How to run

1. Start up all the containers by running docker compose up.
    ```
    $ docker-compose up -d
    ``` 

2. Wait for all containers (especially terraform-service, it's the latest:)) to start and run SQL query to check join
   ```
   INSERT INTO department.employees
   VALUES (6, 'v_shilay666', 'Viktor', 'Shilay', '1996-01-22', 'UNEMPLOYED');
   INSERT INTO department.cars
   VALUES (11, 'BMW', '5 Series (G30/G31) 530i', '2017', 'Petrol', 'Silver', 39000.0, 6);
   ``` 
3. Start KafkaStreamServiceApplication locally
