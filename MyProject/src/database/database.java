package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.method1;
import database.method2;
import database.method3;

public class database {
    public static void main(String[] args) {
    	
    	String[][] racerData = null;
        String[][] trackData = null;
        String[][] raceCarData = null;
        String[][] eventData = null;
        String[][] fanData = null;
        String[][] racesInData = null;
        String[][] pastEventsData = null;
        String[][] racingStyleData = null;
        String[][] driverRecordsData = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Formula1", "Isaac", "password");

            // Queries for each table
            racerData = executeQuery(con, "SELECT * FROM RACER");
            trackData = executeQuery(con, "SELECT * FROM TRACK");
            raceCarData = executeQuery(con, "SELECT * FROM RACE_CAR");
            eventData = executeQuery(con, "SELECT * FROM EVENT");
            fanData = executeQuery(con, "SELECT * FROM FAN");
            racesInData = executeQuery(con, "SELECT * FROM RACES_IN");
            pastEventsData = executeQuery(con, "SELECT * FROM PAST_EVENTS");
            racingStyleData = executeQuery(con, "SELECT * FROM RACING_STYLE");
            driverRecordsData = executeQuery(con, "SELECT * FROM DRIVER_RECORDS");

//             Printing the results
//            printData(racerData, "RACER");
//            printData(trackData, "TRACK");
//            printData(raceCarData, "RACE_CAR");
//            printData(eventData, "EVENT");
//            printData(fanData, "FAN");
//            printData(racesInData, "RACES_IN");
//            printData(pastEventsData, "PAST_EVENTS");
//            printData(racingStyleData, "RACING_STYLE");
//            printData(driverRecordsData, "DRIVER_RECORDS");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("Method 1:");
        method1 test1 = new method1();
        String[][] bandwagoners = test1.method1bandwagoners(driverRecordsData, racerData, fanData);
        
        System.out.println("\nBandwagoners in main:");
        for (String[] bandwagoner : bandwagoners) {
            for (String str : bandwagoner) {
            	if(str != null) {
            		System.out.print(str + " ");
            	}
            }
            System.out.println(); // New line after each bandwagoner
        }
        
        System.out.println("Method 2:");
        method2 test2 = new method2();
        String[] mostPotential = test2.method2Potential(driverRecordsData, racerData);
        
        System.out.println("MostPotential in main:");
        System.out.println("Name: " + mostPotential[1] + mostPotential[2] + " Driver number: " + mostPotential[0] + "\n"
        		+ "Wins: " + mostPotential[3] + " Loses: " + mostPotential[4] + " Team: " + mostPotential[5] + "\n");
        
        
        System.out.println("Method 3:");
        method3 test3 = new method3();
        String[][] packed = test3.howPacked(fanData, racerData, racesInData);
        
        System.out.println("MostPotential in main:");
        for (String[] str : packed) {
        	System.out.println("Location: " + str[0] + " Guests: " + str[1]);
        }
    }

    // Method to execute a query and store the result in a String[][]
    public static String[][] executeQuery(Connection con, String query) throws SQLException {
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);

        int columnCount = rs.getMetaData().getColumnCount();
        rs.last();
        int rowCount = rs.getRow();
        rs.beforeFirst();

        String[][] data = new String[rowCount][columnCount];

        int i = 0;
        while (rs.next()) {
            for (int j = 0; j < columnCount; j++) {
                data[i][j] = rs.getString(j + 1);
            }
            i++;
        }

        return data;
    }

    // Method to print the data
    public static void printData(String[][] data, String tableName) {
        System.out.println("Data from table: " + tableName);
        for (String[] row : data) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
