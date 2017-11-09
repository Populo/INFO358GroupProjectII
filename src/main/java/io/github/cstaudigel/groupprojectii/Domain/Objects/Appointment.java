package io.github.cstaudigel.groupprojectii.Domain.Objects;

import java.sql.Date;

public class Appointment {
    private Stylist stylist;
    private Client client;
    private Date dateTime;
    private Service service;

    public Appointment(Stylist stylist, Client client, Date dateTime, Service service) {
        this.stylist = stylist;
        this.client = client;
        this.dateTime = dateTime;
        this.service = service;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
