package io.github.cstaudigel.groupprojectii.DAL.Implementations;

import io.github.cstaudigel.groupprojectii.DAL.Interfaces.ServiceDAO;
import io.github.cstaudigel.groupprojectii.Domain.Objects.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by chris on 11/14/17
 */

@Component
@Repository
public class ServiceDAOImpl implements ServiceDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * create service in database
     *
     * @param s
     * @return
     */
    @Override
    public Service createService(Service s) {
        String sql = "INSERT INTO SERVICE (SVC_ID, SVC_NAME, SVC_TIME, SVC_COST) " +
                "VALUES(?, ?, ?, ?);";

        jdbcTemplate.update(sql, new Object[] {s.getID(), s.getName(), s.getTime(), s.getCost()});

        return s;
    }

    /**
     * update service in database
     *
     * @param newService
     * @return
     */
    @Override
    public Service modifyService(Service newService) {
        if (this.removeService(newService) != null) {
            return createService(newService);
        }

        return null;

    }

    /**
     * remove service from database
     *
     * @param s
     * @return
     */
    @Override
    public Service removeService(Service s) {
        String sql = "DROP * FROM SERVICE WHERE SVC_ID = ?";

        jdbcTemplate.update(sql, new Object[] {s.getID()});

        return s;
    }

    /**
     * return service from database by code
     *
     * @param code
     * @return
     */
    @Override
    public Service getServiceByCode(int code) {
        String sql = "SELECT * FROM SERVICE WHERE SVC_ID = ?";

        List<Service> service = jdbcTemplate.query(sql, new Object[]{code},
                (rs, rowNum) -> new Service(
                        rs.getInt("SVC_ID"),
                        rs.getString("SVC_NAME"),
                        rs.getInt("SVC_TIME"),
                        rs.getDouble("SVC_COST")
                ));

        return service.get(0);
    }
}
