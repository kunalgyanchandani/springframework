import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

/**
 * Created by gyanc on 7/30/2018.
 */
public class Starter {
    public static void main(String... args) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:hsql://localhost:");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        JdbcTemplate temp = new JdbcTemplate(dataSource);
        List<Map<String, Object>> data = temp.queryForList("select * from dual");
        data.stream().forEach(action -> action.entrySet().stream().forEach(inner ->
        {
            System.out.println(inner);
            System.out.println(inner.getKey());
            System.out.println(inner.getValue());
            System.out.println("-----");
        }));

        System.out.println("StarterJDBC");
    }
}
