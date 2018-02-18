package ajs.x;

import java.util.UUID;

import javax.jws.WebService;

@WebService(
		endpointInterface="ajs.x.AJSPort",
		targetNamespace="urn:X-AJS",
		serviceName="AJSService",
		portName="AJSPort",
		wsdlLocation="AJS.wsdl"
		)
public class DefaultAJSService {
	
	private CvicenieDao cvicenieDao = ObjectFactory.INSTANCE.cvicenieDao();
	
	public PridajCvicenieResponse pridajCvicenie(PridajCvicenieRequest part) throws DuplicitnyZaznam_Exception {
		PridajCvicenieResponse response = new PridajCvicenieResponse();
		String uuid = cvicenieDao.pridajCvicenie(part.nazovPredmetu);
		response.setUuid(uuid);
		return response;
	}

}
