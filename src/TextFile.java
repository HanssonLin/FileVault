

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class TextFile{
		
    ArrayList<String> info;
    PrintWriter writer;
    String fileLocation;
    File textFile;
    
    public TextFile(String filePath) {

        FileScanner reader = new FileScanner();
        info = reader.readAndReturnStringArrayList(filePath);
        fileLocation = filePath;
        //If there is not file there, you will get null
        try {
            textFile = new File(filePath);
        } catch (Exception e) {
            System.out.println(fileLocation);
            System.out.println("There was an error in retrieving the file.");
        }
    }
    
    public void changeInfo(ArrayList<String> sentInfo){
        info = sentInfo;
    }
    public ArrayList getInfo(){
            return(info);
    }
    
    public String getName() {
        return(textFile.getName());
    }
    
    public void wipeAndSave() throws FileNotFoundException{
        //If there is not file there, you will get null
        try {
            writer = new PrintWriter(textFile);
            writer.print("");
            for (String s : info){
                writer.println(s);
            }
            //File was successfully rewritten
            writer.close();
        } catch(Exception e) {
            System.out.println("There has been an error rewriting your file");
        }
    }
	
}
