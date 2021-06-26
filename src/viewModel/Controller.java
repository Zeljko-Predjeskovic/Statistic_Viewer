package viewModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1995);
        xAxis.setUpperBound(2021);
        xAxis.setTickUnit(1);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(25000);
        yAxis.setUpperBound(45000);
        yAxis.setTickUnit(5000);
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
}
