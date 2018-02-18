package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import ajs.x.CvicenieDao;
import ajs.x.DuplicitnyZaznam_Exception;
import ajs.x.ObjectFactory;

public class MysqlCvicenieDaoTest {
	private CvicenieDao cvicenieDao;
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void setUp() throws Exception {
		jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
		cvicenieDao = ObjectFactory.INSTANCE.cvicenieDao();
	}
	
	@Test
	public void testJeVDatabaze() throws DuplicitnyZaznam_Exception {
		String uuid1 = cvicenieDao.pridajCvicenie("Neuronky");
		String uuid2 = cvicenieDao.jeVDatabaze("Neuronky");
		cvicenieDao.zmazCvicenie("Neuronky");
		assertTrue(uuid1.equals(uuid2));
	}

	@Test
	public void testPridajCvicenie() throws DuplicitnyZaznam_Exception {
		String sql = "SELECT COUNT(*) FROM kopr.cvicenie";
		int pocetPred = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(cvicenieDao.pridajCvicenie("Neuronky"));
		int pocetPo = jdbcTemplate.queryForObject(sql, Integer.class);
		cvicenieDao.zmazCvicenie("Neuronky");
		assertEquals(pocetPo, pocetPred + 1);
	}
	
	@Test
	public void testZmazCvicenie() throws DuplicitnyZaznam_Exception {
		cvicenieDao.pridajCvicenie("Neuronky");
		String sql = "SELECT COUNT(*) FROM kopr.cvicenie";
		int pocetPred = jdbcTemplate.queryForObject(sql, Integer.class);
		cvicenieDao.zmazCvicenie("Neuronky");
		int pocetPo = jdbcTemplate.queryForObject(sql, Integer.class);
		assertEquals(pocetPred - 1, pocetPo);
	}

}
