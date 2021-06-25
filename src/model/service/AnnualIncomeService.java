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

}
