package serveur.log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogInteract implements Serializable {

    private final static File file = new File("log.csv");

    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";

    public static List<String> readFile(){
        String line;
        List<String> tabLog = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine())!=null){
                tabLog.add(line);
            }
            br.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tabLog;
    }

    public static void writeFile(String val){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
            bw.write(val+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
