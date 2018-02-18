
package ajs.x;

import javax.xml.bind.annotation.XmlRegistry;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ajs.x package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public enum ObjectFactory {

	INSTANCE;

	private JdbcTemplate jdbcTemplate;

	private CvicenieDao cvicenieDao;

	private PridajCvicenieResponse pridajCvicenieResponse;

	private PridajCvicenieRequest pridajCvicenieRequest;

	public JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUrl("jdbc:mysql://localhost/kopr?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
			dataSource.setUser("kopr");
			dataSource.setPassword("kopr");
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}

	public CvicenieDao cvicenieDao() {
		if (this.cvicenieDao == null) {
			this.cvicenieDao = new MysqlCvicenieDao();
		}
		return cvicenieDao;
	}

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: ajs.x
	 * 
	 */
	private ObjectFactory() {
	}

	/**
	 * Create an instance of {@link PridajCvicenieResponse }
	 * 
	 */
	public PridajCvicenieResponse createPridajCvicenieResponse() {
		if (this.pridajCvicenieResponse == null) {
			this.pridajCvicenieResponse = new PridajCvicenieResponse();
		}
		return pridajCvicenieResponse;
	}

	/**
	 * Create an instance of {@link PridajCvicenieRequest }
	 * 
	 */
	public PridajCvicenieRequest createPridajCvicenieRequest() {
		// return new PridajCvicenieRequest();
		if (this.pridajCvicenieRequest == null) {
			this.pridajCvicenieRequest = new PridajCvicenieRequest();
		}
		return pridajCvicenieRequest;
	}
}
