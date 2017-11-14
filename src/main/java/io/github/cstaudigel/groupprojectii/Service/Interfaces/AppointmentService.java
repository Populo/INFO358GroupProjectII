package io.github.cstaudigel.groupprojectii.Service.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Appointment;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;

import java.sql.Date;
import java.util.List;

/**
 * created by chris on 11/14/17
 */


public interface AppointmentService {


    /**
     * create an appointment in the db
     * @param a
     * @return
     */
    Appointment createAppointment(Appointment a);

    /**
     * returns all appointments for the specified stylist
     * @param s
     * @return
     */
    List<Appointment> getAllAppointmentsForStylist(Stylist s);

    /**
     * returns all appointments for stylist today
     * @param s
     * @return
     */
    List<Appointment> getAppointmentsForStylistToday(Stylist s);

    /**
     * returns all appointments for stylist on specified day
     * @param s
     * @param d
     * @return
     */
    List<Appointment> getAppointmentsForStylistOnDay(Stylist s, Date d);

    /**
     * get appointments for stylist before specified date
     * @param s
     * @param d
     * @return
     */
    List<Appointment> getAppointmentsForStylistBeforeDate(Stylist s, Date d);

    /**
     * get appointments for stylist after specified date
     * @param s
     * @param d
     * @return
     */
    List<Appointment> getAppointmentsForStylistAfterDate(Stylist s, Date d);

    /**
     * get appointments for stylist after today
     * @param s
     * @return
     */
    List<Appointment> getFutureAppointmentsForStylist(Stylist s);

    /**
     * get appointments for stylist before today
     * @param s
     * @return
     */
    List<Appointment> getPastAppointmentsForStylist(Stylist s);

    /**
     * get appointments for all stylists on specified date
     * @param d
     * @return
     */
    List<Appointment> getAppointmentsOnDay(Date d);

    /**
     * get appointments for all stylists today
     * @return
     */
    List<Appointment> getAppointmentsToday();

    /**
     * get appointments for all stylists before specified date
      * @param d
     * @return
     */
    List<Appointment> getAppointmentsBeforeDate(Date d);

    /**
     * get appointments for all stylists after specified date
     * @param d
     * @return
     */
    List<Appointment> getAppointmentsAfterDate(Date d);

    /**
     * get appointments for all stylists in future
     * @return
     */
    List<Appointment> getFutureAppointments();

    /**
     * get appointments for all stylists in past
     * @return
     */
    List<Appointment> getPastAppointments();
}
