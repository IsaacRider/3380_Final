package Main;

public class method1 {

	public String[][] method1bandwagoners(String[][] DRIVER_RECORDSdata, String[][] RACERdata, String[][] FANdata){
        //First Function
		
		int rowCount = 0;
        
//        System.out.println("");
        
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
        
        System.out.println("\nThe bandwagoner to regular fan ratio:");
//        System.out.println(FANdata.length);
//        System.out.println(bandwagoners.length);
        float ratio = bandwagoners.length/FANdata.length;
        System.out.println(ratio);
        
		return bandwagoners;
	}
}
