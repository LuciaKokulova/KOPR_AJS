package ajs.x;

import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MysqlCvicenieDao implements CvicenieDao {

	private JdbcTemplate jdbcTemplate;
	
	public MysqlCvicenieDao() {
		this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
	}

	public String jeVDatabaze(String nazovPredmetu) {
		String sql = "SELECT uuid FROM kopr.cvicenie WHERE nazovPredmetu = ?;";
		try {
			String uuid = jdbcTemplate.queryForObject(sql, new Object[] { nazovPredmetu }, String.class);
			return uuid;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public String pridajCvicenie(String nazovPredmetu) throws DuplicitnyZaznam_Exception {
		if (jeVDatabaze(nazovPredmetu) != null) {
			throw new DuplicitnyZaznam_Exception("Cvi�enie s t�mto n�zvom sa u� v datab�ze nach�dza, zvo�te in� n�zov!", new DuplicitnyZaznam());
		}
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("nazovPredmetu", nazovPredmetu);
		String uuid =  UUID.randomUUID().toString();
		parameters.addValue("uuid", uuid);

		new SimpleJdbcInsert(ObjectFactory.INSTANCE.getJdbcTemplate())
			.withTableName("cvicenie")
			.usingColumns("uuid", "nazovPredmetu")
			.execute(parameters);

		return uuid;
	}
	
	public void zmazCvicenie(String nazovPredmetu) {
		String sql = "DELETE FROM kopr.cvicenie WHERE nazovPredmetu = ?;";
		jdbcTemplate.update(sql, new Object[] { nazovPredmetu });
	}

}
