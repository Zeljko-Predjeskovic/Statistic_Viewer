package viewModel;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import model.service.AnnualIncomeService;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private AnnualIncomeService men = new AnnualIncomeService("src/statisticFiles/men");
    private AnnualIncomeService women= new AnnualIncomeService("src/statisticFiles/women");
    private AnnualIncomeService both= new AnnualIncomeService("src/statisticFiles/menAndWomen");

    @FXML
    LineChart<Number,Number> lineChart;

    @FXML
    NumberAxis xAxis;

    @FXML
    NumberAxis yAxis;

    @FXML
    ComboBox comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll("Men's Yearly Income",
                "Women's Yearly Income",
                "Both Yearly Income");

        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1995);
        xAxis.setUpperBound(2021);
        xAxis.setTickUnit(1);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(15000);
        yAxis.setUpperBound(45000);
        yAxis.setTickUnit(5000);
    }

    public void comboBox(){
        switch (comboBox.getValue().toString()){
            case "Men's Yearly Income" :
                lineChart.getData().clear();
                menIncome();
                break;
            case "Women's Yearly Income" :
                lineChart.getData().clear();
                womenIncome();
                break;
            case "Both Yearly Income" :
                lineChart.getData().clear();
                bothIncome();
                break;
            default:
                System.out.println("No item clicked");
        }
    }

    public void menIncome(){
        lineChart.setTitle("Annual Income for Men in Austria");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Mens Annual Income/Year");
        //populating the series with data
        for (int i = 0; i<men.getAllValues().size(); i++){
            series.getData().add(new XYChart.Data(men.getAllKeys().get(i), men.getAllValues().get(i)));
        }

        lineChart.getData().add(series);

    }

    public void womenIncome(){
        lineChart.setTitle("Annual Income for Women in Austria");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Women's Annual Income/Year");
        //populating the series with data
        for (int i = 0; i<women.getAllValues().size(); i++){
            series.getData().add(new XYChart.Data(women.getAllKeys().get(i), women.getAllValues().get(i)));
        }

        lineChart.getData().add(series);

    }

    public void bothIncome(){
        menIncome();
        womenIncome();
        lineChart.setTitle("Annual Income for Women and Men in Austria");
    }
}
