package com.example.girishattri.travelloid.Model;

public class Tour
{
    int id;
    String name;
    String title;
    boolean isInternational;
    String summary;
    String description;
    boolean isactive;
    boolean isfeatured;
    String image;

    public Tour() {
    }

    public Tour(int id, String name, String title, boolean isInternational, String summary, String description, boolean isactive, boolean isfeatured, String image) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.isInternational = isInternational;
        this.summary = summary;
        this.description = description;
        this.isactive = isactive;
        this.isfeatured = isfeatured;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public boolean isfeatured() {
        return isfeatured;
    }

    public void setIsfeatured(boolean isfeatured) {
        this.isfeatured = isfeatured;
    }
}
