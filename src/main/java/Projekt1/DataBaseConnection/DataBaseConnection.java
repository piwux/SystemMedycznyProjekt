package Projekt1.DataBaseConnection;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "postgresDataBase";
        String databaseUser = "postgres";
        String databasePassword = "postgrespostgres123$";
        String url = "jdbc:postgresql://database-1.cbu2kotcg0eq.eu-west-1.rds.amazonaws.com:5432/postgres";

        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setUrl(url);
        ds.setUser(databaseUser);
        ds.setPassword(databasePassword);

        try {
            databaseLink = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}

