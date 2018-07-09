import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileScanner {
    //construct it so can be used publicly
    public FileScanner() {
    }

    /*
    -reads the given file fouund at the file location
    -and saves each line into a index position in a String[]
    -then returns said String[]
    */
    
    
    public ArrayList<String> readAndReturnStringArrayList(String fileLocation) {
        
        ArrayList<String> stuff = new ArrayList();
        //get directory
        String fullFileName = fileLocation;
        try {
            
            FileReader fr = new FileReader(fullFileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null){
                stuff.add(line);
                
            }
            br.close();
        }
        
        catch(Exception e){
            System.out.println("Something went wrong reading the file");
        }
        return(stuff);
    }

}

