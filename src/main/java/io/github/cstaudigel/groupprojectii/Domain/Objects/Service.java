package io.github.cstaudigel.groupprojectii.Domain.Objects;

public class Service {

    private int id;
    private String name;
    private int time;
    private double cost;

    public Service(int id, String name, int time, double cost) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.cost = cost;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
