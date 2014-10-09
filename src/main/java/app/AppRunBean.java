/**
 * 
 */
package app;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

import domain.Subscriber;

/**
 * @author arpan
 *
 */
@Component
public class AppRunBean {

	@Autowired	
	CassandraTemplate cassandraTemplate;
	
	public void run()
	{		
		Subscriber subscriber = new Subscriber();
		String randId = UUID.randomUUID().toString();
		subscriber.setId(randId);
		subscriber.setChargingId(randId);
		subscriber.setUsername("admin");
		subscriber.setPassword("password");

		
		cassandraTemplate.insert(subscriber);
		

	}
}
