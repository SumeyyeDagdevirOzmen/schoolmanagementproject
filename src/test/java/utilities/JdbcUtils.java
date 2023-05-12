package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    //1. Adım: Driver'a kaydol
    //2. Adım: Datbase'e bağlan
    public static Connection connectToDataBase(String hostName, String dbName, String username, String password) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/" + dbName, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (connection != null) {
            System.out.println("Connection Success");
        } else {
            System.out.println("Connection Fail");
        }

        return connection;
    }

    //3. Adım: Statement oluştur.
    public static Statement createStatement() {


        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return statement;
    }

    //4. Adım: Query çalıştır.
    public static boolean execute(String sql) {
        boolean isExecute;
        try {
            isExecute = statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isExecute;
    }


    //5. Adım: Bağlantı ve Statement'ı kapat.
    public static void closeConnectionAndStatement() {

        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (connection.isClosed() && statement.isClosed()) {
                System.out.println("Connection and statement closed!");

            } else {
                System.out.println("Connection and statement NOT closed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Table oluşturan method
    public static void createTable(String tableName, String... columnName_dataType) {
        StringBuilder columnName_dataValue = new StringBuilder("");

        for (String w : columnName_dataType) {

            columnName_dataValue.append(w).append(",");

        }

        columnName_dataValue.deleteCharAt(columnName_dataValue.length() - 1);

        try {
            statement.execute("CREATE TABLE " + tableName + "(" + columnName_dataValue + ")");
            System.out.println("Table " + tableName + " successfully created!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void executeQuery(String tableName, String... columnName) {
        StringBuilder columns = new StringBuilder("");
        for (String w : columnName) {
            columns.append(w).append(",");
        }
        columns.deleteCharAt(columns.length() - 1);

        Statement statement = JdbcUtils.createStatement();

        try {
            String sql2 = "select   " + columns + " from " + tableName;
            ResultSet resultset1 = statement.executeQuery(sql2);
            while (resultset1.next()) {

                for (String j : columnName) {

                    System.out.println(resultset1.getObject(j) + " ");
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public static void executeUpdate(String tableName, String setColumn, String newValues, String Condition) {

        Statement statement = JdbcUtils.createStatement();
        String sql1 = "  update " + tableName + " set " + setColumn + "=" + newValues + " where " + Condition + "";

        try {
            int desLignesQuiChange = statement.executeUpdate(sql1);
            System.out.println("desLignesQuiChange = " + desLignesQuiChange);
            System.out.println("Table updated succesfully! ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    //The method to insert data into table
    public static void insertDataIntoTable(String tableName, String... columnName_Value) {

        StringBuilder columnNames = new StringBuilder("");
        StringBuilder values = new StringBuilder("");

        for (String w : columnName_Value) {
            columnNames.append(w.split(" ")[0]).append(",");
            values.append(w.split(" ")[1]).append(",");
        }

        //"INSERT INTO "+tableName+"(id, name, address) VALUES(123, 'john', 'new york')"
        columnNames.deleteCharAt(columnNames.lastIndexOf(","));
        values.deleteCharAt(values.lastIndexOf(","));

        String query = "INSERT INTO " + tableName + "(" + columnNames + ") VALUES(" + values + ")";

        try {
            statement.execute(query);
            System.out.println("Data inserted into table " + tableName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //The method to get column data into a list
    public static List<Object> getColumnList(String columnName, String tableName) {

        List<Object> columnData = new ArrayList<>();

        String query = "SELECT " + columnName + " FROM " + tableName;

        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                columnData.add(resultSet.getObject(1));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return columnData;
    }

    public static List<Map<String, Object>> getQueryResultMap(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return rowList;

    }














































    //The method to get column data into a list
    public static List<String> getColumnListString (String columnName, String tableName) {

        List<String> columnData = new ArrayList<>();

        String query = "SELECT " + columnName + " FROM " + tableName;

        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                columnData.add(resultSet.getString(1));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return columnData;
    }
}


