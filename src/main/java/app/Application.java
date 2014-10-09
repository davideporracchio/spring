/**
 * 
 */
package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.cassandra.core.CassandraOperations;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import conf.CassandraConfiguration;
import domain.Person;
import domain.User;

/**
 * @author arpan
 *
 */
public class Application {

	
	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CassandraConfiguration.class);		
		CassandraOperations operations =  (CassandraOperations)ctx.getBean("casops");
		
		
		
		User user = new User();
		user.setId(1);
		user.setFname("Jack");
		user.setLname("Sparrow");
		user.setAddress("Black Pearl");
		user.setSal(0.00);
		
		operations.insert(user);
		
		Long l = operations.count(User.class);	
		
		
		
		System.out.println("Count : "+l);
		
		
		
		Select select = QueryBuilder.select().from("users");
		select.where(QueryBuilder.eq("id", 1));

		User p = operations.selectOne(select, User.class);
		System.out.println(String.format("Found Person with Name [%s] for id [%s]", p.getFname(), p.getId()));

	}

}
