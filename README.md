# Javafx gui for visualising the annual income per person in austria

#### Source for the statistics: 
https://www.statistik.at/web_de/statistiken/menschen_und_gesellschaft/soziales/personen-einkommen/jaehrliche_personen_einkommen/index.html


### Setup on IntelliJ

Java version: adopt-openjdk-11

Javafx: javafx-sdk-11.0.2

1. open project in IDE 

2. got to File -> project structures -> libraries and add the /lib folder path from your javafx sdk

![setup libraries](images/setup1.PNG)

3. Before you run the Main class, make sure to add VM options in your launcher.

![setup vm](images/setup2.PNG)

write:

    --module-path "yourPath/.jdks/javafx-sdk-11.0.2/lib" --add-modules javafx.controls,javafx.fxml

4. Now you scan start your JavaFx application

### See the Statistiscs

![Annual Income for Men in Austria](images/MenStats.PNG)
![Annual Income for Men and Women in Austria](images/BothStats.PNG)
![Annual Income for Men in Austria in Nett](images/BothNett.PNG)
![Annual Income](images/barGraph.PNG)
