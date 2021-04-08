package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleDao {
    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(
                             "SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?")) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            List<String> x = getStatement(stmt);
            if (x.size() == 1) {
                return x.get(0);
            } else {
                throw new IllegalStateException("result error");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("select error");
        }
    }

    private List<String> getStatement(PreparedStatement stmt) throws SQLException {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString(1));
            }
        }
        return result;
    }

}
