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
        String fileRACES_IN = "src/Main/RACES_IN.csv"; // Driver_no, Event_name
        String[][] RACES_INdata = null;
        
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
        
        try (BufferedReader calculateDimensions = new BufferedReader(new FileReader(fileRACES_IN))) {
        	calculateDimensions.readLine();//Skip first line
            //Counting number of rows and columns
        	rowCount = 0;
            while ((line = calculateDimensions.readLine()) != null) {
                rowCount++;
            }
            calculateDimensions.close();
            
            //Read information
            BufferedReader read = new BufferedReader(new FileReader(fileRACES_IN));
            	
            read.readLine(); //Skip first line
            //Initializing 2D array with appropriate size
//            System.out.println(rowCount);
//            System.out.println(columnCount);
            RACES_INdata = new String[rowCount][2];
//            System.out.println(rowCount);
            //Reading data into 2D array
            int row = 0;

            //Reading data into 2D array
            while ((line = read.readLine()) != null) {
                String[] rowData = line.split(cvsSplitBy);
                for (int col = 0; col < rowData.length; col++) {
                	RACES_INdata[row][col] = rowData[col];
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        for (String[] row : RACES_INdata) { //Print RACERs
//            for (String element : row) {
//                System.out.print(element + " ");
//            }
//            System.out.println(); // new line after each row
//        }
       
        System.out.println("Method 1:");
        method1 test1 = new method1();
        String[][] bandwagoners = test1.method1bandwagoners(DRIVER_RECORDSdata, RACERdata, FANdata);
        
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
        String[] mostPotential = test2.method2Potential(DRIVER_RECORDSdata, RACERdata);
        
        System.out.println("MostPotential in main:");
        System.out.println("Name: " + mostPotential[1] + mostPotential[2] + " Driver number: " + mostPotential[0] + "\n"
        		+ "Wins: " + mostPotential[3] + " Loses: " + mostPotential[4] + " Team: " + mostPotential[5] + "\n");
        
        
        System.out.println("Method 3:");
        method3 test3 = new method3();
        String[][] packed = test3.howPacked(FANdata, RACERdata, RACES_INdata);
        
        System.out.println("MostPotential in main:");
        for (String[] str : packed) {
        	System.out.println("Location: " + str[0] + " Guests: " + str[1]);
        }
        
    }
}
