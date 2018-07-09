
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 549271
 */
public class Account {
    
    private String password;
    static int id;
    private  String RFID; // whats on the card
    
    
    public Account(String password, String RFID) {
        this.password = password;
        id++;
        this.RFID = RFID;
    }
    
    public String getPassword() {
        return(password);
    }
    
    public int getID() {
        return(id);
    }
    
    public String getRFID(){
        return(RFID);
    }
    
    public boolean passwordCheck(String input) {
        if (input.equals(password)) {
            return (true);
        } else {
            return (false);
        }
    }

    public boolean RFIDCheck(String InputRFID) {
        if (InputRFID.equals(RFID))
            return(true);
        else
            return(false);
    }
}
