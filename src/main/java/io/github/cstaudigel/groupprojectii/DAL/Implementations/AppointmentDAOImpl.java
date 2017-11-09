package io.github.cstaudigel.groupprojectii.DAL.Implementations;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.AppointmentDAO;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Appointment;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Client;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * add Appointment to database
     *
     * @param a
     */
    @Override
    public void CreateAppointment(Appointment a) {
        String sql = "INSERT INTO APPOINTMENT (A_STYLIST, A_CLIENT, A_SERVICE, A_TIME) VALUES (?, ?, ?, ?);";

        jdbcTemplate.update(sql, new Object[] {
           a.getStylist().getUsername(),
           a.getClient().getUsername(),
           a.getService().getName(),
           a.getDateTime()
        });
    }

    /**
     * get all appointment at specified time
     *
     * @param time
     */
    @Override
    public Appointment GetAppointmentAtTime(Date time) {
        return null;
    }

    /**
     * get appointments on specified date
     *
     * @param day
     */
    @Override
    public List<Appointment> GetAppointmentsOnDay(Date day) {
        return null;
    }

    /**
     * get appointments at specific time for specific sylist
     *
     * @param s
     * @param time
     */
    @Override
    public Appointment GetAppointmentAtTimeForStylist(Stylist s, Date time) {
        return null;
    }

    /**
     * get appointments on specific day for stylist
     *
     * @param s
     * @param time
     */
    @Override
    public List<Appointment> GetAppointmentsOnDayForStylist(Stylist s, Date time) {
        return null;
    }

    /**
     * get all future appointments for stylist
     *
     * @param s
     */
    @Override
    public List<Appointment> GetFutureAppointmentsForStylist(Stylist s) {
        return null;
    }

    /**
     * get all past appointments for stylist
     *
     * @param s
     */
    @Override
    public List<Appointment> GetPastAppointmentsForStylist(Stylist s) {
        return null;
    }

    /**
     * get all appointments for stylist
     *
     * @param s
     */
    @Override
    public List<Appointment> GetAllAppointmentsForStylist(Stylist s) {
        List<Appointment> appointments;
        // TODO Serivce call to get client
        // TODO Service call to get service

        String sql = "SELECT * FROM APPOINTMENT, STYLIST WHERE STYLIST.S_USERNAME = ?";

        Object[] inputs = new Object[] {s.getUsername()};

/*
        appointments = jdbcTemplate.query(sql, inputs,
                (rs, rowNum) -> new Appointment()

        ));
*/

        throw new NotImplementedException();
    }
}
