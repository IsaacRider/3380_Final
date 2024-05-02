package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.List;
import Main.method1;

public class Main {
    public static void main(String[] args) {
        String fileRACER = "src/Main/RACER.csv"; // Driver_no, Fname, Lname, Team, Current_wins, Current_losses
        String[][] RACERdata = null;
        String fileDRIVER_RECORDS = "src/Main/DRIVER_RECORDS.csv"; // Driver_no, Season, Current_season_wins, Current_season_losses
        String[][] DRIVER_RECORDSdata = null;
        String fileFAN = "src/Main/FAN.csv"; // Driver_no, Name, Fan_of
        String[][] FANdata = null;
        
        String line = "";
        String cvsSplitBy = ",";
        int rowCount = 0;
        int columnCount = 0;


        try (BufferedReader calculateDimensions = new BufferedReader(new FileReader(fileRACER))) {
        	calculateDimensions.readLine();//Skip first line
            //Counting number of rows and columns
            while ((line = calculateDimensions.readLine()) != null) {
                rowCount++;
                String[] rowData = line.split(cvsSplitBy);
                if (rowData.length > columnCount) {
                    columnCount = rowData.length;
                }
            }
            calculateDimensions.close();
            
            //Read information
            BufferedReader read = new BufferedReader(new FileReader(fileRACER));
            	
            read.readLine(); //Skip first line
            //Initializing 2D array with appropriate size
            RACERdata = new String[rowCount][columnCount];
            int row = 0;

            //Reading data into 2D array
            while ((line = read.readLine()) != null) {
                String[] rowData = line.split(cvsSplitBy);
                for (int col = 0; col < rowData.length; col++) {
                    RACERdata[row][col] = rowData[col];
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        for (String[] row : RACERdata) { //Print RACERs
//            for (String element : row) {
//                System.out.print(element + " ");
//            }
//            System.out.println(); // new line after each row
//        }
        
        
        rowCount = 0;
        columnCount = 0;
        
//        System.out.println();
        
        try (BufferedReader calculateDimensions = new BufferedReader(new FileReader(fileDRIVER_RECORDS))) {
        	calculateDimensions.readLine();//Skip first line
            //Counting number of rows and columns
            while ((line = calculateDimensions.readLine()) != null) {
                rowCount++;
                String[] rowData = line.split(cvsSplitBy);
                if (rowData.length > columnCount) {
                    columnCount = rowData.length;
                }
            }
            calculateDimensions.close();
            
            //Read information
            BufferedReader read = new BufferedReader(new FileReader(fileDRIVER_RECORDS));
            	
            read.readLine(); //Skip first line
            //Initializing 2D array with appropriate size
            DRIVER_RECORDSdata = new String[rowCount][columnCount];
            int row = 0;

            //Reading data into 2D array
            while ((line = read.readLine()) != null) {
                String[] rowData = line.split(cvsSplitBy);
                for (int col = 0; col < rowData.length; col++) {
                	DRIVER_RECORDSdata[row][col] = rowData[col];
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        for (String[] row : DRIVER_RECORDSdata) { //Print Driver Records
//            for (String element : row) {
//                System.out.print(element + " ");
//            }
//            System.out.println(); // new line after each row
//        }
        
        
        rowCount = 0;
        columnCount = 0;
        
//        System.out.println();
        
        try (BufferedReader calculateDimensions = new BufferedReader(new FileReader(fileFAN))) {
        	calculateDimensions.readLine();//Skip first line
            //Counting number of rows and columns
            while ((line = calculateDimensions.readLine()) != null) {
                rowCount++;
                String[] rowData = line.split(cvsSplitBy);
                if (rowData.length > columnCount) {
                    columnCount = rowData.length;
                }
            }
            calculateDimensions.close();
            
            //Read information
            BufferedReader read = new BufferedReader(new FileReader(fileFAN));
            	
            read.readLine(); //Skip first line
            //Initializing 2D array with appropriate size
            FANdata = new String[rowCount][columnCount];
            int row = 0;

            //Reading data into 2D array
            while ((line = read.readLine()) != null) {
                String[] rowData = line.split(cvsSplitBy);
                for (int col = 0; col < rowData.length; col++) {
                    FANdata[row][col] = rowData[col];
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        for (String[] row : FANdata) { //Print Fans
//            for (String element : row) {
//                System.out.print(element + " ");
//            }
//            System.out.println(); // new line after each row
//        }
       
        
        method1 test = new method1();
        String[][] bandwagoners = test.method1bandwagoners(DRIVER_RECORDSdata, RACERdata, FANdata);
        
        System.out.println("\nBandwagoners in main:");
        for (String[] bandwagoner : bandwagoners) {
            for (String str : bandwagoner) {
                System.out.print(str + " ");
            }
            System.out.println(); // New line after each bandwagoner
        }
        
    }
}
