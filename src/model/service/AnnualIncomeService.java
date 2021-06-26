package model.service;

import model.fileAccess.FileAccess;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class AnnualIncomeService {

    HashMap<Integer, ArrayList<Integer>> data;

    public AnnualIncomeService(String filepath){
        File f = new File(filepath);
        data = new FileAccess().readStatsPerYear(f);
    }

    public HashMap<Integer, ArrayList<Integer>> getData() {
        return data;
    }

    public ArrayList<Integer> getAllKeys(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (Integer key : data.keySet() ) {
            l.add(key);
        }
        return l;
    }

    public ArrayList<Integer> getAllValues(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (Integer key : data.keySet() ) {
            l.add(data.get(key).get(3));
        }
        return l;
    }


    public ArrayList<Integer> getAllValuesNett(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (Integer key : data.keySet() ) {
            l.add(data.get(key).get(7));
        }
        return l;
    }

}
