package Main;

import java.util.ArrayList;
import java.util.List;


//Racer: Driver_no, Fname, Lname, Team, Current_wins, Current_losses
//Fan: Driver_no, Name, Fan_of
//Races_in: Driver_no, Event_name

public class method3 {

    public String[][] howPacked(String[][] FANdata, String[][] RACERdata, String[][] RACES_INdata) {
        String[] eventsList = new String[RACES_INdata.length];
        int index = 0;

        // Finding unique events
        for (String[] event : RACES_INdata) {
            String newEvent = event[1];
            if (!isEventIncluded(eventsList, newEvent)) {
                eventsList[index] = newEvent;
                index++;
            }
        }

        // Print unique events
//        for (String event : eventsList) {
//            if (event != null) {
//                System.out.println(event);
//            }
//        }

        // Creating members array
        String[][] members = new String[index][2]; // Using 'index' as the size since it represents the number of unique events

        // Initializing members array with event names and 0 fans
        for (int i = 0; i < index; i++) {
            members[i][0] = eventsList[i]; // Location
            members[i][1] = "0"; // Guests
        }

        
        for (String[] member : members) {
            for (String[] fanEvent : FANdata) {
                for (String[] racesinEvent : RACES_INdata) {
                    if (fanEvent[0].equals(racesinEvent[0]) && member[0].equals(racesinEvent[1])) {
//                    	System.out.println(fanEvent[0] + racesinEvent[0] + racesinEvent[1]);
                        int currentFans = Integer.parseInt(member[1]);
                        currentFans++;
                        member[1] = String.valueOf(currentFans);
                    }
                }
            }
        }
        
        return members;
    }

    // Check if item is already in the stringList.
    private boolean isEventIncluded(String[] stringList, String item) {
        for (String e : stringList) {
            if (e != null && e.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
