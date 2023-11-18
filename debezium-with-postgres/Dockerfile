FROM quay.io/debezium/connect:2.3

# Add filter dependencies
COPY debezium-scripting/*.jar /kafka/connect/debezium-connector-postgres/
COPY groovy/*.jar /kafka/connect/debezium-connector-postgres/
