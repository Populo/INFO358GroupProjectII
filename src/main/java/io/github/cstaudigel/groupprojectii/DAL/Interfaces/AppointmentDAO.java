package io.github.cstaudigel.groupprojectii.DAL.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Appointment;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;

import java.util.Date;
import java.util.List;

public interface AppointmentDAO {
    /**
     * add Appointment to database
     */
    void CreateAppointment(Appointment a);

    /**
     * get all appointment at specified time
     */
    Appointment GetAppointmentAtTime(Date time);

    /**
     * get appointments on specified date
     */
    List<Appointment> GetAppointmentsOnDay(Date day);

    /**
     * get appointments at specific time for specific sylist
     */
    Appointment GetAppointmentAtTimeForStylist(Stylist s, Date time);

    /**
     * get appointments on specific day for stylist
     */
    List<Appointment> GetAppointmentsOnDayForStylist(Stylist s, Date time);

    /**
     * get all future appointments for stylist
     */
    List<Appointment> GetFutureAppointmentsForStylist(Stylist s);

    /**
     * get all past appointments for stylist
     */
    List<Appointment> GetPastAppointmentsForStylist(Stylist s);

    /**
     * get all appointments for stylist
     */
    List<Appointment> GetAllAppointmentsForStylist(Stylist s);
}
