package io.github.cstaudigel.groupprojectii.Service.Implementations;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.AppointmentDAO;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Appointment;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;
import io.github.cstaudigel.groupprojectii.Service.Interfaces.AppointmentService;
import io.github.cstaudigel.groupprojectii.Service.Interfaces.ClientService;
import io.github.cstaudigel.groupprojectii.Service.Interfaces.ServiceService;
import io.github.cstaudigel.groupprojectii.Service.Interfaces.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * created by chris on 11/14/17
 */

@Component
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentDAO appointmentDAO;
    private ServiceService serviceService;
    private ClientService clientService;
    private StylistService stylistService;

    @Autowired
    public AppointmentServiceImpl(AppointmentDAO appointmentDAO, ServiceService serviceService, ClientService  clientService, StylistService stylistService) {
        this.appointmentDAO = appointmentDAO;
        this.serviceService = serviceService;
        this.clientService = clientService;
        this.stylistService = stylistService;
    }

    private List<Appointment> convertStringAppointmentToObjectAppointment(List<Appointment> appointments) {
        List<Appointment> realAppointments = new ArrayList<>();

        for (Appointment a : appointments) {
            Appointment appointment = new Appointment(
                    stylistService.getStylistByUsername(a.getStylistUsername()),
                    clientService.getClientByUsername(a.getClientUsername()),
                    a.getDateTime(),
                    serviceService.getServiceByCode(a.getServiceCode())
            );
            realAppointments.add(appointment);
        }

        return realAppointments;
    }

    /**
     * create an appointment in the db
     *
     * @param a
     * @return appointment
     */
    @Override
    public Appointment createAppointment(Appointment a) {
        return appointmentDAO.createAppointment(a);
    }

    /**
     * returns all appointments for the specified stylist
     *
     * @param s
     * @return
     */
    @Override
    public List<Appointment> getAllAppointmentsForStylist(Stylist s) {
        List<Appointment> appointments = appointmentDAO.getAllAppointmentsForStylist(s);

        return convertStringAppointmentToObjectAppointment(appointments);
    }

    /**
     * returns all appointments for stylist today
     *
     * @param s
     * @return
     */
    @Override
    public List<Appointment> getAppointmentsForStylistToday(Stylist s) {
        return this.getAppointmentsForStylistOnDay(s, Date.valueOf(LocalDate.now()));
    }

    /**
     * returns all appointments for stylist on specified day
     *
     * @param s
     * @param d
     * @return
     */
    @Override
    public List<Appointment> getAppointmentsForStylistOnDay(Stylist s, Date d) {
        List<Appointment> appointments = appointmentDAO.getAppointmentsOnDayForStylist(s, d);

        return convertStringAppointmentToObjectAppointment(appointments);
    }

    /**
     * get appointments for stylist before specified date
     *
     * @param s
     * @param d
     * @return
     */
    @Override
    public List<Appointment> getAppointmentsForStylistBeforeDate(Stylist s, Date d) {
        List<Appointment> appointments = appointmentDAO.getPastAppointmentsForStylist(s, d);

        return convertStringAppointmentToObjectAppointment(appointments);
    }

    /**
     * get appointments for stylist after specified date
     *
     * @param s
     * @param d
     * @return
     */
    @Override
    public List<Appointment> getAppointmentsForStylistAfterDate(Stylist s, Date d) {
        List<Appointment> appointments = appointmentDAO.getFutureAppointmentsForStylist(s, d);

        return convertStringAppointmentToObjectAppointment(appointments);
    }

    /**
     * get appointments for stylist after today
     *
     * @param s
     * @return
     */
    @Override
    public List<Appointment> getFutureAppointmentsForStylist(Stylist s) {
        return this.getAppointmentsForStylistAfterDate(s, Date.valueOf(LocalDate.now()));
    }

    /**
     * get appointments for stylist before today
     *
     * @param s
     * @return
     */
    @Override
    public List<Appointment> getPastAppointmentsForStylist(Stylist s) {
        return this.getAppointmentsForStylistBeforeDate(s, Date.valueOf(LocalDate.now()));
    }

    /**
     * get appointments for all stylists on specified date
     *
     * @param d
     * @return
     */
    @Override
    public List<Appointment> getAppointmentsOnDay(Date d) {
        List<Appointment> appointments = appointmentDAO.getAppointmentsOnDay(d);

        return convertStringAppointmentToObjectAppointment(appointments);
    }

    /**
     * get appointments for all stylists today
     *
     * @return
     */
    @Override
    public List<Appointment> getAppointmentsToday() {
        return this.getAppointmentsOnDay(Date.valueOf(LocalDate.now()));
    }

    /**
     * get appointments for all stylists before specified date
     *
     * @param d
     * @return
     */
    @Override
    public List<Appointment> getAppointmentsBeforeDate(Date d) {
        List<Appointment> appointments = appointmentDAO.getAppointmentsBeforeDay(d);

        return convertStringAppointmentToObjectAppointment(appointments);
    }

    /**
     * get appointments for all stylists after specified date
     *
     * @param d
     * @return
     */
    @Override
    public List<Appointment> getAppointmentsAfterDate(Date d) {
        List<Appointment> appointments = appointmentDAO.getAppointmentsAfterDay(d);

        return convertStringAppointmentToObjectAppointment(appointments);
    }

    /**
     * get appointments for all stylists in future
     *
     * @return
     */
    @Override
    public List<Appointment> getFutureAppointments() {
        return this.getAppointmentsAfterDate(Date.valueOf(LocalDate.now()));
    }

    /**
     * get appointments for all stylists in past
     *
     * @return
     */
    @Override
    public List<Appointment> getPastAppointments() {
        return this.getAppointmentsBeforeDate(Date.valueOf(LocalDate.now()));
    }
}
