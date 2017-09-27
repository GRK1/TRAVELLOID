package com.example.girishattri.travelloid.Model;

/**
 * Created by Abhishek on 9/14/2017.
 */

public class Itinerary {
    private String day;
    private String highlight1;
    private String highlight2;
    private String description;

    public Itinerary() {
    }

    public Itinerary(String day, String highlight1, String highlight2, String description) {
        this.day = day;
        this.highlight1 = highlight1;
        this.highlight2 = highlight2;
        this.description = description;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHighlight1() {
        return highlight1;
    }

    public void setHighlight1(String highlight1) {
        this.highlight1 = highlight1;
    }

    public String getHighlight2() {
        return highlight2;
    }

    public void setHighlight2(String highlight2) {
        this.highlight2 = highlight2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
