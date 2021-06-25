package viewModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.service.AnnualIncomeService;

public class Controller {

    private AnnualIncomeService men = new AnnualIncomeService("src/statisticFiles/men");
    private AnnualIncomeService women= new AnnualIncomeService("src/statisticFiles/women");;
    private AnnualIncomeService both= new AnnualIncomeService("src/statisticFiles/menAndWomen");;

    @FXML Label label;
    @FXML Label label2;

    public void manageButton() {
        label.setText(men.getData().get(2015).get(0).toString() + "€");
        label2.setText(men.getData().get(1997).get(0).toString() + "€");
    }
}
