package com.example.girishattri.travelloid.Model;


public class Package
{
    int packageid;
    String title;
    Double cost;
    String duration;
    boolean isactive;
    boolean featured;
    String image;

    public Package(int packageid, String title, Double cost, String duration, boolean isactive, boolean featured, String url) {
        this.packageid = packageid;
        this.title = title;
        this.cost = cost;
        this.duration = duration;
        this.isactive = isactive;
        this.featured = featured;
        this.image = url;
    }

    public Package() {
    }

    public int getPackageid() {
        return packageid;
    }

    public void setPackageid(int packageid) {
        this.packageid = packageid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
