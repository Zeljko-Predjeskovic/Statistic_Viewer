package viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
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
    GridPane gridPane;

    @FXML
    LineChart<Number,Number> lineChart;

    @FXML
    BarChart<String,Number> barChart;

    @FXML
    NumberAxis xAxis;

    @FXML
    NumberAxis yAxis;

    @FXML
    CategoryAxis barXAxis;

    @FXML
    NumberAxis barYAxis;

    @FXML
    ComboBox comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll("Men's Yearly Income",
                "Women's Yearly Income",
                "Both Yearly Income",
                "Arithmetic mean",
                "Men's Yearly Income Nett",
                "Women's Yearly Income Nett",
                "Both Yearly Income Nett",
                "Arithmetic mean Nett",
                "Bar chart annual income");

        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1995);
        xAxis.setUpperBound(2021);
        xAxis.setTickUnit(3);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(10000);
        yAxis.setUpperBound(45000);
        yAxis.setTickUnit(5000);

        barYAxis.setAutoRanging(false);
        barYAxis.setLowerBound(15000);
        barYAxis.setUpperBound(45000);
        barYAxis.setTickUnit(5000);

        barXAxis.setAnimated(false);

    }

    public void comboBox(){
        switch (comboBox.getValue().toString()){
            case "Men's Yearly Income" :
                lineChart.getData().clear();
                menIncome(false, "Mens Annual Income in ???/Year", men);
                break;
            case "Women's Yearly Income" :
                lineChart.getData().clear();
                womenIncome(false,"Women's Annual Income in ???/Year",women);
                break;
            case "Both Yearly Income" :
                lineChart.getData().clear();
                bothIncome(false);
                break;
            case "Arithmetic mean" :
                lineChart.getData().clear();
                meanIncome(false,"Annual Income in ???/Year",both);
                break;
            case "Men's Yearly Income Nett" :
                lineChart.getData().clear();
                menIncome(true, "Mens Annual Income in ???/Year Nett",men);
                break;
            case "Women's Yearly Income Nett" :
                lineChart.getData().clear();
                womenIncome(true,"Women's Annual Income in ???/Year Nett",women);
                break;
            case "Both Yearly Income Nett" :
                lineChart.getData().clear();
                bothIncome(true);
                break;
            case "Arithmetic mean Nett" :
                lineChart.getData().clear();
                meanIncome(true,"Annual Income in ???/Year Nett",both);
                break;
            case "Bar chart annual income" :
                barChart.getData().clear();
                barChartIncome();
                break;
            default:
                System.out.println("No item clicked");
        }
    }



    public XYChart.Series bindIncome(boolean nett, String title, AnnualIncomeService data){
        XYChart.Series series = new XYChart.Series();
        series.setName(title);

        for (int i = 0; i<men.getAllValues().size(); i++){
            if(nett){
                series.getData().add(new XYChart.Data(data.getAllKeys().get(i), data.getAllValuesNett().get(i)));
            }
            else {
                series.getData().add(new XYChart.Data(data.getAllKeys().get(i), data.getAllValues().get(i)));
            }
        }
        return series;
    }

    public void menIncome(boolean nett, String title, AnnualIncomeService data){
        lineChart.setTitle("Annual Income for Men in Austria");

        lineChart.getData().add(bindIncome(nett, title, data));

    }

    public void womenIncome(boolean nett, String title, AnnualIncomeService data){
        lineChart.setTitle("Annual Income for Women in Austria");

        lineChart.getData().add(bindIncome(nett,title,data));

    }

    public void bothIncome(boolean nett){
        menIncome(nett,"Mens Annual Income in ???/Year",men);
        womenIncome(nett,"Women's Annual Income in ???/Year",women);
        lineChart.setTitle("Annual Income for Women and Men in Austria");
    }

    public void meanIncome(boolean nett,String title, AnnualIncomeService data) {
        lineChart.setTitle("Arithmetic mean Income for Men and Women in Austria");

        lineChart.getData().add(bindIncome(nett,title,data));
    }

    private XYChart.Series createSeries(AnnualIncomeService data, String name, ObservableList<Integer> ol){
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        for (int d:ol) {
            series.getData().add(new XYChart.Data(""+d, data.getData().get(d).get(3)));
        }
        return series;
    }

    public void barChartIncome() {

        barChart.setTitle("Annual Income in ???");
        xAxis.setLabel("Year");
        yAxis.setLabel("Income in ???");

        ObservableList<Integer> ol = FXCollections.observableArrayList(2000,2010,2019);

        XYChart.Series series1 = createSeries(men,"men",ol);


        XYChart.Series series2 = createSeries(women,"women",ol);


        XYChart.Series series3 = createSeries(both,"both",ol);


        barChart.getData().addAll(series1, series2, series3);
    }
}
