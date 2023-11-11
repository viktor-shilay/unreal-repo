terraform {
  required_providers {
    kafka-connect = {
      source  = "Mongey/kafka-connect"
      version = "0.3.0"
    }
  }
}


provider "kafka-connect" {
  url = "http://kafka-connector:8083"
}

resource "kafka-connect_connector" "unreal-connector" {
  name = "unreal-connector"

  config = {
    "slot.name" : "unreal_connector",
    "name"                                     = "unreal-connector"
    "connector.class"                          = "io.debezium.connector.postgresql.PostgresConnector",
    "tasks.max"                                = "1",
    "database.hostname"                        = "unreal-postgres",
    "database.port"                            = "5432",
    "database.user"                            = "postgres",
    "database.password"                        = "root",
    "database.dbname"                          = "unreal_db",
    "database.server.name"                     = "unreal_db",
    "table.include.list"                       = "department.employees",
    "topic.prefix"                             = "unreal-topic",
    "database.history.kafka.bootstrap.servers" = "kafka=9092",
    "database.history.kafka.topic"             = "schema_changes.employees",
    "value.converter"                          = "org.apache.kafka.connect.json.JsonConverter",
    "value.converter.schemas.enable"           = "false",
    "key.converter"                            = "org.apache.kafka.connect.json.JsonConverter",
    "key.converter.schemas.enable"             = "false",
    "tombstones.on.delete"                     = "false",
    "transforms"                               = "unwrap, moveOpToHeader",
    "transforms.unwrap.type"                   = "org.apache.kafka.connect.transforms.ExtractField$Key",
    "transforms.unwrap.field"                  = "id",
    "transforms.unwrap.add.headers"            = "op",
    "transforms.moveOpToHeader.type"           = "org.apache.kafka.connect.transforms.HeaderFrom$Value",
    "transforms.moveOpToHeader.fields"         = "op",
    "transforms.moveOpToHeader.headers"        = "op",
    "transforms.moveOpToHeader.operation"      = "move"
  }
}

resource "kafka-connect_connector" "kafka-stream-connector" {
  name = "kafka-stream-connector"

  config = {
    "slot.name" = "kafka_stream_connector",
    "name"                                     = "kafka-stream-connector",
    "connector.class"                          = "io.debezium.connector.postgresql.PostgresConnector",
    "tasks.max"                                = "1",
    "database.hostname"                        = "unreal-postgres",
    "database.port"                            = "5432",
    "database.user"                            = "postgres",
    "database.password"                        = "root",
    "database.dbname"                          = "unreal_db",
    "database.server.name"                     = "unreal_db",
    "table.include.list"                       = "department.employees, department.cars",
    "topic.prefix"                             = "kafka-stream-topic",
    "database.history.kafka.bootstrap.servers" = "kafka=9092",
    "database.history.kafka.topic"             = "schema_changes.department",
    "value.converter"                          = "org.apache.kafka.connect.json.JsonConverter",
    "value.converter.schemas.enable"           = "false",
    "key.converter"                            = "org.apache.kafka.connect.json.JsonConverter",
    "key.converter.schemas.enable"             = "false",
    "transforms"                               = "unwrap, filter, extractKey",
    "transforms.unwrap.type"                   = "io.debezium.transforms.ExtractNewRecordState",
    "transforms.unwrap.add.fields"             = "op",
    "transforms.filter.type"                   = "io.debezium.transforms.Filter",
    "transforms.filter.language"               = "jsr223.groovy",
    "transforms.filter.condition"              = "value.__op == 'c'",
    "transforms.extractKey.type"               = "org.apache.kafka.connect.transforms.ExtractField$Key",
    "transforms.extractKey.field"              = "id",
    "decimal.handling.mode"                    = "string"
  }
}
