package com.example.airlinesafety.Server;

public class Airline {

    String name;
    int incidents;
    int accidents;
    int fatalities;
    long availSeatKmWeek;

    public long getAvailSeatKmWeek() {
        return availSeatKmWeek;
    }

    public void setAvailSeatKmWeek(long availSeatKmWeek) {
        this.availSeatKmWeek = availSeatKmWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncidents() {
        return incidents;
    }

    public void setIncidents(int incidents) {
        this.incidents = incidents;
    }

    public int getAccidents() {
        return accidents;
    }

    public void setAccidents(int accidents) {
        this.accidents = accidents;
    }

    public int getFatalities() {
        return fatalities;
    }

    public void setFatalities(int fatalities) {
        this.fatalities = fatalities;
    }
}
