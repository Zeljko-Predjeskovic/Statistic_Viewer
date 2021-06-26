package test;

import model.service.AnnualIncomeService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestAnnualIncomeService {

    AnnualIncomeService annualIncomeService = new AnnualIncomeService("src/statisticFiles/men");

    @Test
    public void verifyAnnualIncomeDataGetter(){
        Assertions.assertTrue(!annualIncomeService.getData().isEmpty());
        Assertions.assertTrue(annualIncomeService.getData().containsKey(1997));
        Assertions.assertTrue(annualIncomeService.getData().containsKey(2019));
    }

    @Test
    public void verifyAnnualIncomeGetAllKeys(){
        System.out.println(annualIncomeService.getAllKeys());
        Assertions.assertTrue(!annualIncomeService.getAllKeys().isEmpty());
    }

    @Test
    public void verifyAnnualIncomeGetAllValues(){
        System.out.println(annualIncomeService.getAllValues());
        Assertions.assertTrue(!annualIncomeService.getAllValues().isEmpty());
    }
}
