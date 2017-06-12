package com.apress.pss.terrormovies.model;

/**
 * Created ${name}
 *
 * @author wanggang
 * @since ${Date}
 */
public class Movie {

    private String name;
    private double budget;

    public Movie(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
