package test;

import model.service.AnnualIncomeService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class TestAnnualIncomeService {

    AnnualIncomeService annualIncomeService;

    @Test
    public void verifyAnnualIncomeDataGetter(){
        annualIncomeService = new AnnualIncomeService("src/statisticFiles/men");

        Assertions.assertTrue(!annualIncomeService.getData().isEmpty());
        Assertions.assertTrue(annualIncomeService.getData().containsKey(1997));
        Assertions.assertTrue(annualIncomeService.getData().containsKey(2019));
    }
}
