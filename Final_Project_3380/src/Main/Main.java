package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.List;

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
        
        for (String[] row : RACERdata) { //Print RACERs
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // new line after each row
        }
        
        
        rowCount = 0;
        columnCount = 0;
        
        System.out.println();
        
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
        
        for (String[] row : DRIVER_RECORDSdata) { //Print Driver Records
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // new line after each row
        }
        
        
        rowCount = 0;
        columnCount = 0;
        
        System.out.println();
        
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
        
        for (String[] row : FANdata) { //Print Fans
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // new line after each row
        }
       
        
        
        //First Function
        
        System.out.println("");
        
        String[] bestRacer = {"0", "0", "0", "0"};
        
        //Find best racer.
        for (String[] row : DRIVER_RECORDSdata) { // Driver_no, Season, Current_season_wins, Current_season_losses
        	if(Integer.parseInt(row[2]) > Integer.parseInt(bestRacer[2])) {
        		bestRacer = row;
        	}
        }
        
        String[] bestRacerRecord = {"", "", "", "", "", ""};
        
        for (String[] row : RACERdata) { // Driver_no, Fname, Lname, Team, Current_wins, Current_losses
        	if(Integer.parseInt(row[0]) == Integer.parseInt(bestRacer[0])) {
        		bestRacerRecord = row;
        	}
        }
        
        System.out.println("Best Racer: ");
        for (String str : bestRacerRecord) {
            System.out.print(str);
            System.out.print(" ");
        }
        
        rowCount = 0;
        
        for (String[] row : FANdata) {
            if(Integer.parseInt(row[0]) == Integer.parseInt(bestRacerRecord[0])) {
            	rowCount++;
            }
        }
        
        String[][] bandwagoners = new String[rowCount][2];
        
        int index = 0;
        // FANS: Driver_no, Name, Fan_of
        // RACER: Driver_no, Fname, Lname, Team, Current_wins, Current_losses
        for (String[] row : FANdata) {
            if(Integer.parseInt(row[0]) == Integer.parseInt(bestRacerRecord[0])) {
            	bandwagoners[index] = row;
            }
        }
        
        System.out.println("\nbandwagoners:");
        for (String[] bandwagoner : bandwagoners) {
        	for (String str : bandwagoner) {
                System.out.print(str);
                System.out.print(" ");
            }
        }
        
        System.out.println("The bandwagoner to regular fan ratio:");
        System.out.println(FANdata.length);
        System.out.println(bandwagoners.length);
        float ratio = bandwagoners.length/FANdata.length;
        System.out.println(ratio);
    }
}
