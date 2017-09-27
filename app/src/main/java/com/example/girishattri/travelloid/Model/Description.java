package com.example.girishattri.travelloid.Model;

import java.util.ArrayList;

/**
 * Created by Abhishek on 9/17/2017.
 */

public class Description {
    private int packageid;
    private String highlight;
    private String overview;
    private ArrayList<String> inclusion;
    private ArrayList<String> exclusion;

    public Description(int packageid, String highlight, String overview, ArrayList<String> inclusion, ArrayList<String> exclusion) {
        this.packageid = packageid;
        this.highlight = highlight;
        this.overview = overview;
        this.inclusion = inclusion;
        this.exclusion = exclusion;
    }

    public Description() {
    }

    public int getPackageid() {
        return packageid;
    }

    public void setPackageid(int packageid) {
        this.packageid = packageid;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public ArrayList<String> getInclusion() {
        return inclusion;
    }

    public void setInclusion(ArrayList<String> inclusion) {
        this.inclusion = inclusion;
    }

    public ArrayList<String> getExclusion() {
        return exclusion;
    }

    public void setExclusion(ArrayList<String> exclusion) {
        this.exclusion = exclusion;
    }
}
