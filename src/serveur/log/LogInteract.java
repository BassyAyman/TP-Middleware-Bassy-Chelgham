package serveur.log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogInteract {

    private final static String pathFile = "log.csv";

    public static List<String> ReadFile(){
        String line;
        List<String> tabLog = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
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
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile));
            bw.write(val+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
