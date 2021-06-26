package model.service;

import model.fileAccess.FileAccess;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Zeljko Predjeskovic
 *
 * @date 26.06.2021
 */
public class AnnualIncomeService {

    HashMap<Integer, ArrayList<Integer>> data;

    /**
     * @param filepath file your want to read
     */
    public AnnualIncomeService(String filepath){
        File f = new File(filepath);
        data = new FileAccess().readStatsPerYear(f);
    }

    public HashMap<Integer, ArrayList<Integer>> getData() {
        return data;
    }

    /**
     * @return All keys of the data HashMap
     */
    public ArrayList<Integer> getAllKeys(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (Integer key : data.keySet() ) {
            l.add(key);
        }
        return l;
    }


    /**
     * @return a List of every value of each key
     */
    public ArrayList<Integer> getAllValues(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (Integer key : data.keySet() ) {
            l.add(data.get(key).get(3));
        }
        return l;
    }


    /**
     * @return a List with every value of each key
     */
    public ArrayList<Integer> getAllValuesNett(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (Integer key : data.keySet() ) {
            l.add(data.get(key).get(7));
        }
        return l;
    }

}
