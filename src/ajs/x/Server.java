package ajs.x;

import javax.xml.ws.Endpoint;

public class Server {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8088/ajs/ws", new DefaultAJSService());
	}
}
