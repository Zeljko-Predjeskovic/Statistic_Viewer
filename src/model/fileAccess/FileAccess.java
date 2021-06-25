package model.fileAccess;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileAccess {

    private HashMap<Integer,ArrayList<Integer>> data;

    public FileAccess(){
        data = new HashMap<Integer,ArrayList<Integer>>();
    }

    public HashMap<Integer,ArrayList<Integer>> readStatsPerYear(File f) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf-8"))) {
            String line = null;
            while ((line = br.readLine()) != null) {

                String[] str = line.split(",");
                ArrayList<Integer> brutto = new ArrayList<>();

                for (int i = 1; i< str.length; i++){
                    brutto.add(Integer.parseInt(str[i]));
                }

                int currentKey = Integer.parseInt(str[0]);
                data.put(currentKey ,brutto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public HashMap<Integer, ArrayList<Integer>> getData() {
        return data;
    }
}
