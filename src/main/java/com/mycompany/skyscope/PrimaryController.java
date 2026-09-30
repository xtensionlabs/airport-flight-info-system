package com.mycompany.skyscope;

import com.mycompany.skyscope.model.Flight;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

    @FXML private TextField searchField;
    @FXML private TableView<Flight> flightTable;
    @FXML private TableColumn<Flight, String> colFlightNum;
    @FXML private TableColumn<Flight, String> colAirline;
    @FXML private TableColumn<Flight, String> colDestination;
    @FXML private TableColumn<Flight, String> colTime;
    @FXML private TableColumn<Flight, String> colGate;

    // Master list of flights
    private final ObservableList<Flight> masterFlightList = FXCollections.observableArrayList(
        new Flight("DL482", "Delta", "New York (JFK)", "12:45", "B2"),
        new Flight("UA109", "United", "Chicago (ORD)", "13:10", "A5"),
        new Flight("BA248", "British Airways", "London (LHR)", "13:30", "C12"),
        new Flight("EK702", "Emirates", "Dubai (DXB)", "14:05", "B8"),
        new Flight("AF914", "Air France", "Paris (CDG)", "14:20", "D3")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 1. Link table columns to Flight properties
        colFlightNum.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        colAirline.setCellValueFactory(new PropertyValueFactory<>("airline"));
        colDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("scheduledTime"));
        colGate.setCellValueFactory(new PropertyValueFactory<>("gate"));

        // 2. Wrap master list in a FilteredList for instant searching
        FilteredList<Flight> filteredData = new FilteredList<>(masterFlightList, b -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(flight -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();

                if (flight.getFlightNumber().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (flight.getDestination().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (flight.getAirline().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        // 3. Wrap in SortedList so column headers sort correctly
        SortedList<Flight> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(flightTable.comparatorProperty());

        // 4. Bind data to the table
        flightTable.setItems(sortedData);
    }
}