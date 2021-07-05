package in.vishnu.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import in.vishnu.util.Util;

@Configuration
public class DataBaseConfig {
	@Bean
	public JdbcTemplate jdbcTemplate() {
		DataSource jdbcTemplate = Util.getConnection();
		return new JdbcTemplate(jdbcTemplate);
	}
}
