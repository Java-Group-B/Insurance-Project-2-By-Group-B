package com.insuranceproject2.monitoring;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
@Controller
public class MyDBHealthService implements HealthIndicator{
	public static final String DB_Service ="Database Service";
	@Autowired
	private Environment environment;
	public boolean isServiceUp() throws IOException{
		String address=environment.getProperty("dummyService.address");
		String port=environment.getProperty("dummyService.port");
		System.out.println("Address= "+address+" Port= "+port);
		
	
		return isAddressReachable(address, Integer.parseInt(port), 3000);
	}
	private static boolean isAddressReachable(String address,int port, int timeout) throws IOException {
		Socket isSocket=new Socket();
		try {
			isSocket.connect(new InetSocketAddress(address, port),timeout);
			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
			return false;
		}
		finally {
			isSocket.close();
		}
	
	}
	
	@Override
	public Health health() {
		
		
		try {
			if(isServiceUp()) {
				return Health.up().withDetail(DB_Service,"Database service is running up...").build();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return Health.up().withDetail(DB_Service,"Database service is running down...").build();
		
	
	}

}
