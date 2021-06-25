package test;

import model.fileAccess.FileAccess;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class TestFileAccess {

    private FileAccess fileAccess = new FileAccess();

    @Test
    public void verifyReadStatsPerYear(){
       File f = new File("src/statisticFiles/men");
        HashMap<Integer, ArrayList<Integer>> erg = fileAccess.readStatsPerYear(f);

        Assertions.assertTrue(!erg.isEmpty());
        Assertions.assertTrue(erg.containsKey(1997));
        Assertions.assertTrue(erg.containsKey(2019));
    }

}
