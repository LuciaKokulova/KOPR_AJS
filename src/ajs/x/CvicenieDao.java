package ajs.x;

public interface CvicenieDao {
	
	String jeVDatabaze(String nazovPredmetu);
	
	String pridajCvicenie(String nazovPredmetu) throws DuplicitnyZaznam_Exception;
	
	void zmazCvicenie(String nazovPredmetu);

}
