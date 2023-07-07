import java.sql.Connection;

import connection.Datasource;

public class App {
    public static void main(String[] args) throws Exception {
        Connection connection = Datasource.getConnection();

        connection.close();
    }
}
