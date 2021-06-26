package model.fileAccess;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for accessing the files with the given information
 */
public class FileAccess {
    /**
     * @param f
     * We have 3 files we can use. We can watch either mens, womens or both annual income together
     *
     * @return
     * Returning the hashmap of the stats
     */
    public HashMap<Integer,ArrayList<Integer>> readStatsPerYear(File f) {
        /**
         * We are using a HashMap with the year as the key and a ArrayList of the income
         * with the postions 1 - 3: gross income 4: arithmetic mean, 5 - 7: nett gross 8: arithmetic mean
         */
        HashMap<Integer,ArrayList<Integer>> data = new HashMap<Integer,ArrayList<Integer>>();
        /**
         * Buffered reader to read the files
         */
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            /**
             * Simple line reading
             */
            String line = null;
            while ((line = br.readLine()) != null) {

                /**
                 * Splitting the red line
                 */
                String[] str = line.split(",");

                /**
                 * An ArrayList where we add the income of the year
                 */
                ArrayList<Integer> income = new ArrayList<>();

                /**
                 * going through the quartals and adding them into income
                 */
                for (int i = 1; i< str.length; i++){
                    income.add(Integer.parseInt(str[i]));
                }
                /**
                 * Setting key and value into HashMap
                 */
                int currentKey = Integer.parseInt(str[0]);
                data.put(currentKey ,income);
            }
        } catch (Exception e) {
           throw new RuntimeException("Reading statistic per year failed! ",e);
        }
        return data;
    }
}
