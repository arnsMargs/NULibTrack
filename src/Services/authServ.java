package Services;

import LibTrackModel.*;

public class authServ {
    public static boolean register(String email, String password, String role){
        if(!email.contains("@")){
            return false;
        }

        if(role.equals("Librarian")){
            dB.users.add(new modelLib(email, password, role));
            return true;
        } else if(role.equals("Patron")){
            dB.users.add(new modelPat(email, password, role));
            return true;
        } else {
            return false;
        }
    }
}