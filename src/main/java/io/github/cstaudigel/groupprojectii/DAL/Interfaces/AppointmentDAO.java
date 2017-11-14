package io.github.cstaudigel.groupprojectii.DAL.Interfaces;

import io.github.cstaudigel.groupprojectii.Domain.Objects.Appointment;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;

import java.sql.Date;
import java.util.List;

public interface AppointmentDAO {
    /**
     * add Appointment to database
     */
    Appointment createAppointment(Appointment a);

    /**
     * get appointments on specified date
     */
    List<Appointment> getAppointmentsOnDay(Date day);

    /**
     * get appointments on specific day for stylist
     */
    List<Appointment> getAppointmentsOnDayForStylist(Stylist s, Date time);

    /**
     * get all future appointments for stylist
     */
    List<Appointment> getFutureAppointmentsForStylist(Stylist s, Date time);

    /**
     * get all past appointments for stylist
     */
    List<Appointment> getPastAppointmentsForStylist(Stylist s, Date time);

    /**
     * get all appointments for stylist
     */
    List<Appointment> getAllAppointmentsForStylist(Stylist s);

    /**
     * get all appointments before specified day from db
     * @param time
     * @return
     */
    List<Appointment> getAppointmentsBeforeDay(Date time);

    /**
     * get all appointments after specified day
     * @param time
     * @return
     */
    List<Appointment> getAppointmentsAfterDay(Date time);
}
