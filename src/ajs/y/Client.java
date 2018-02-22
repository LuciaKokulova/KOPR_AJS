package ajs.y;

public class Client {
	 public static void main(String[] args) throws DuplicitnyZaznam_Exception {
		AJSService service = new AJSService();
		AJSPort port = service.getAJSPort();
		
		PridajCvicenieRequest request = new PridajCvicenieRequest();
		request.setNazovPredmetu("Kryptografia");

		PridajCvicenieResponse response = port.pridajCvicenie(request);
	    System.out.println(response.getUuid());
	    
	    // test na vyhodenie výnimky
	    // port.pridajCvicenie(request);
	}
}