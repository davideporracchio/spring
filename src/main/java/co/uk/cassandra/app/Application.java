/**
 * 
 */
package co.uk.cassandra.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.uk.cassandra.conf.CassandraConfig;
import co.uk.cassandra.domain.User;
import co.uk.cassandra.repository.UserRepository;

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
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CassandraConfig.class);		
		//CassandraOperations operations =  (CassandraOperations)ctx.getBean("casops");
		//CassandraOperations operations =  (CassandraOperations)ctx.getBean("casops");
		UserRepository pdao = ctx.getBean(UserRepository.class);
		
		User user = new User();
		user.setId(1);
		user.setFname("Jack");
		user.setLname("Sparrow");
		user.setAddress("Black Pearl");
		user.setSal(0.00);
		
		pdao.delete(user);
		
		//Long l = operations.count(User.class);	
		
		
		
		//System.out.println("Count : "+l);
		
		
		
		//Select select = QueryBuilder.select().from("users");
		//select.where(QueryBuilder.eq("id", 1));

		//User p = operations.selectOne(select, User.class);
		//System.out.println(String.format("Found Person with Name [%s] for id [%s]", p.getFname(), p.getId()));

	}

}
