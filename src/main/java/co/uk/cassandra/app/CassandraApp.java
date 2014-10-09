package co.uk.cassandra.app; 
 
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import co.uk.cassandra.domain.Person;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
 
public class CassandraApp { 
 
 private static final Logger LOG = LoggerFactory.getLogger(CassandraApp.class); 
 
 private static Cluster cluster; 
 private static Session session; 
 
 public static void main(String[] args) { 
 
  //try { 
 
   cluster = Cluster.builder().addContactPoints("127.0.0.1").build(); 
 
   session = cluster.connect("mykeyspace"); 
 
   CassandraOperations cassandraOps = new CassandraTemplate(session); 
 
   cassandraOps.insert(new Person("1234567890", "David", 40)); 
 
   Select s = QueryBuilder.select().from("person"); 
   s.where(QueryBuilder.eq("id", "1234567890")); 
 
   LOG.info(cassandraOps.queryForObject(s, Person.class).getId()); 
 
   cassandraOps.truncate("person"); 
 
 
 } 
} 