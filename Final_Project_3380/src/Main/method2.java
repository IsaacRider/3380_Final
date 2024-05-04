package Main;

public class method2 {

	public String[] method2Potential(String[][] DRIVER_RECORDSdata, String[][] RACERdata){
        //Second Function
        
        System.out.println("");
        
        String[] bestRacer = {"0", "0", "0", "0"};
        
        //Find best racer currently.
        for (String[] row : DRIVER_RECORDSdata) { // Driver_no, Season, Current_season_wins, Current_season_losses
        	if(Integer.parseInt(row[2]) > (Integer.parseInt(bestRacer[2]) - Integer.parseInt(bestRacer[3]))) {
        		bestRacer = row;
        	}
        }
        
        String[] bestRacerRecord = {"", "", "", "", "", ""};
        
        for (String[] row : RACERdata) { // Driver_no, Fname, Lname, Team, Current_wins, Current_losses
        	if(Integer.parseInt(row[0]) == Integer.parseInt(bestRacer[0])) {
        		bestRacerRecord = row;
        	}
        }
        
        System.out.println("The racer with the most potential currently is: " + bestRacerRecord[1] + bestRacerRecord[2] + "\n"
        		+ "This is because they have the most wins-loses amount.");
        int winLoseRatio = Integer.parseInt(bestRacer[2]) - Integer.parseInt(bestRacer[3]);
        System.out.println("This racer has a (" + String.valueOf(winLoseRatio) + ") win to lose ratio\n");
        
        
        return bestRacerRecord;
	}
}
