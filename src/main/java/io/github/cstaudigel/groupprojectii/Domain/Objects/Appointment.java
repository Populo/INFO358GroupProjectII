package io.github.cstaudigel.groupprojectii.Domain.Objects;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.AppointmentDAO;
import io.github.cstaudigel.groupprojectii.Service.Implementations.ClientServiceImpl;
import io.github.cstaudigel.groupprojectii.Service.Interfaces.ClientService;

import java.sql.Date;

public class Appointment {
    private Stylist stylist;
    private Client client;
    private Date dateTime;
    private Service service;

    private String stylistUsername, clientUsername;
    private int serviceCode;

    public Appointment(Stylist stylist, Client client, Date dateTime, Service service) {
        this.stylist = stylist;
        this.client = client;
        this.dateTime = dateTime;
        this.service = service;
    }

    public Appointment(String stylistUsername, String clientUsername, Date dateTime, int serviceCode) {
        this.stylistUsername = stylistUsername;
        this.clientUsername = clientUsername;
        this.serviceCode = serviceCode;
        this.dateTime = dateTime;
    }

    public String getStylistUsername() {
        return stylistUsername;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public int getServiceCode() {
        return serviceCode;
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
