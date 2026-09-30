/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skyscope.model;

/**
 *
 * @author wendy
 */

import javafx.beans.property.*;
public class Flight {
    private final StringProperty flightNumber = new SimpleStringProperty();
    private final StringProperty airline = new SimpleStringProperty();
    private final StringProperty destination = new SimpleStringProperty();
    private final StringProperty scheduledTime = new SimpleStringProperty();
    private final StringProperty gate = new SimpleStringProperty();
    private final BooleanProperty pinned = new SimpleBooleanProperty(false);
    
    public Flight(String flightNumber, String airline, String destination, String scheduledTime, String gate) {
        this.flightNumber.set(flightNumber);
        this.airline.set(airline);
        this.destination.set(destination);
        this.scheduledTime.set(scheduledTime);
        this.gate.set(gate);
    }
    
    public StringProperty flightNumberProperty() { return flightNumber; }
    public String getFlightNumber() { return flightNumber.get(); }

    public StringProperty airlineProperty() { return airline; }
    public String getAirline() { return airline.get(); }

    public StringProperty destinationProperty() { return destination; }
    public String getDestination() { return destination.get(); }

    public StringProperty scheduledTimeProperty() { return scheduledTime; }
    public String getScheduledTime() { return scheduledTime.get(); }

    public StringProperty gateProperty() { return gate; }
    public String getGate() { return gate.get(); }
    public void setGate(String gate) { this.gate.set(gate); }

    public BooleanProperty pinnedProperty() { return pinned; }
    public boolean isPinned() { return pinned.get(); }
    public void setPinned(boolean pinned) { this.pinned.set(pinned); 
}
    
    
   
    
}
