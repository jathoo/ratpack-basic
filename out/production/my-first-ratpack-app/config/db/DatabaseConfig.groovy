package config.db

class DatabaseConfig {

    String dbHost = "127.0.0.1"
    String dbUser = "informa"
    String db = "YathuTest"
    String dbPassword = "password"
    Integer port = 5432

    String getJdbcUrl(){
        "jdbc:postgresql://${getDbHost()}:${getPort()}/${getDb()}"
    }
}
