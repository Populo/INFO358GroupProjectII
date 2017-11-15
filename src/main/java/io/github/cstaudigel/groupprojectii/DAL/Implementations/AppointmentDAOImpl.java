package io.github.cstaudigel.groupprojectii.DAL.Implementations;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.AppointmentDAO;
import io.github.cstaudigel.groupprojectii.DAL.Interfaces.ClientDAO;
import io.github.cstaudigel.groupprojectii.DAL.Interfaces.StylistDAO;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Appointment;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Client;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Stylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Component
@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

    private JdbcTemplate jdbcTemplate;
    private ClientDAO clientDAO;
    private StylistDAO stylistDAO;

    @Autowired
    public AppointmentDAOImpl(JdbcTemplate jdbcTemplate, ClientDAO clientDAO, StylistDAO stylistDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.clientDAO = clientDAO;
        this.stylistDAO = stylistDAO;
    }

    /**
     * add Appointment to database
     *
     * @param a
     */
    @Override
    public Appointment createAppointment(Appointment a) {
        String sql = "INSERT INTO APPOINTMENT (A_STYLIST, A_CLIENT, A_SERVICE, A_TIME) VALUES (?, ?, ?, ?);";

        jdbcTemplate.update(sql, new Object[] {
           a.getStylist().getUsername(),
           a.getClient().getUsername(),
           a.getService().getName(),
           a.getDateTime()
        });

        return a;
    }

    /**
     * get appointments on specified date
     *
     * @param day
     */
    @Override
    public List<Appointment> getAppointmentsOnDay(Date day) {
        List<Appointment> appointments;

        String sql = "SELECT * FROM APPOINTMENT WHERE A_TIME = ?";

        Object[] inputs = new Object[] {day};

        appointments = jdbcTemplate.query(sql, inputs,
                (rs, rowNum) -> new Appointment(
                        rs.getString("A_STYLIST"),
                        rs.getString("A_CLIENT"),
                        rs.getDate("A_TIME"),
                        rs.getInt("A_SERVICE")
                ));

        return appointments;
    }

    /**
     * get appointments on specific day for stylist
     *
     * @param s
     * @param time
     */
    @Override
    public List<Appointment> getAppointmentsOnDayForStylist(Stylist s, Date time) {
        List<Appointment> appointments;

        String sql = "SELECT * FROM APPOINTMENT WHERE A_TIME = ? AND A_STYLIST = ?";

        Object[] inputs = new Object[] {time, s.getUsername()};

        appointments = jdbcTemplate.query(sql, inputs,
                (rs, rowNum) -> new Appointment(
                        rs.getString("A_STYLIST"),
                        rs.getString("A_CLIENT"),
                        rs.getDate("A_TIME"),
                        rs.getInt("A_SERVICE")
                ));

        return appointments;
    }

    /**
     * get all future appointments for stylist
     *
     * @param s
     */
    @Override
    public List<Appointment> getFutureAppointmentsForStylist(Stylist s, Date time) {
        List<Appointment> appointments;

        String sql = "SELECT * FROM APPOINTMENT WHERE A_TIME > ? AND A_STYLIST = ?";

        Object[] inputs = new Object[] {time, s.getUsername()};

        appointments = jdbcTemplate.query(sql, inputs,
                (rs, rowNum) -> new Appointment(
                        rs.getString("A_STYLIST"),
                        rs.getString("A_CLIENT"),
                        rs.getDate("A_TIME"),
                        rs.getInt("A_SERVICE")
                ));

        return appointments;
    }

    /**
     * get all past appointments for stylist
     *
     * @param s
     */
    @Override
    public List<Appointment> getPastAppointmentsForStylist(Stylist s, Date time) {
        List<Appointment> appointments;

        String sql = "SELECT * FROM APPOINTMENT WHERE A_TIME < ? AND A_STYLIST = ?";

        Object[] inputs = new Object[] {time, s.getUsername()};

        appointments = jdbcTemplate.query(sql, inputs,
                (rs, rowNum) -> new Appointment(
                        rs.getString("A_STYLIST"),
                        rs.getString("A_CLIENT"),
                        rs.getDate("A_TIME"),
                        rs.getInt("A_SERVICE")
                ));

        return appointments;
    }

    /**
     * get all appointments for stylist
     *
     * @param s
     */
    @Override
    public List<Appointment> getAllAppointmentsForStylist(Stylist s) {
        List<Appointment> appointments;

        String sql = "SELECT * FROM APPOINTMENT, STYLIST WHERE STYLIST.S_USERNAME = ?";

        Object[] inputs = new Object[] {s.getUsername()};


        appointments = jdbcTemplate.query(sql, inputs,
                (rs, rowNum) -> new Appointment(
                        rs.getString("A_STYLIST"),
                        rs.getString("A_CLIENT"),
                        rs.getDate("A_TIME"),
                        rs.getInt("A_SERVICE")
                ));

        return appointments;
    }

    /**
     * get all appointments before specified day from db
     * @param time
     * @return
     */
    @Override
    public List<Appointment> getAppointmentsBeforeDay(Date time) {
        List<Appointment> appointments;

        String sql = "SELECT * FROM APPOINTMENT WHERE A_TIME < ?";

        Object[] inputs = new Object[] {time};

        appointments = jdbcTemplate.query(sql, inputs,
                (rs, rowNum) -> new Appointment(
                        rs.getString("A_STYLIST"),
                        rs.getString("A_CLIENT"),
                        rs.getDate("A_TIME"),
                        rs.getInt("A_SERVICE")
                ));

        return appointments;
    }

    /**
     * get all appointments after specified day
     * @param time
     * @return
     */
    public List<Appointment> getAppointmentsAfterDay(Date time) {
        List<Appointment> appointments;

        String sql = "SELECT * FROM APPOINTMENT WHERE A_TIME > ?";

        Object[] inputs = new Object[] {time};

        appointments = jdbcTemplate.query(sql, inputs,
                (rs, rowNum) -> new Appointment(
                        rs.getString("A_STYLIST"),
                        rs.getString("A_CLIENT"),
                        rs.getDate("A_TIME"),
                        rs.getInt("A_SERVICE")
                ));

        return appointments;
    }
}
