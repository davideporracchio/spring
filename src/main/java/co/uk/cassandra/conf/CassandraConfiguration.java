/**
 * 
 */
package co.uk.cassandra.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.policies.LoadBalancingPolicy;

/**
 * @author arpan
 * 
 */
@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(CassandraConfiguration.class);

	private static final String DEFAULT_KEY_SPACE_NAME = "mykeyspace";
	private static final String DEFALUT_CONNECTION_POINTS = "127.0.0.1";
	private static final int DEFAULT_PORT = 9042;

	private static final int DEFAULT_MAX_POOL_CONNECTION = 50;

	@Override
	protected String getKeyspaceName() {
		return DEFAULT_KEY_SPACE_NAME;
	}
	
	@Bean(name="casops")	
	public CassandraOperations operatrions() throws Exception {

		return new CassandraTemplate(session().getObject(), new MappingCassandraConverter(new BasicCassandraMappingContext()));
	}
/*
	@Bean(name = "cTemplate")
	public CassandraOperations cTemplate() throws Exception {
		logger.info("Creating cassandra template and returning it");
		return new CassandraTemplate(session().getObject(), new MappingCassandraConverter(new BasicCassandraMappingContext()));
		// return new CassandraTemplate(session, super.cassandraConverter());
	}
*/
	@Override
	protected PoolingOptions getPoolingOptions() {
		PoolingOptions options = new PoolingOptions();
		options.setMaxConnectionsPerHost(HostDistance.LOCAL, DEFAULT_MAX_POOL_CONNECTION);
		return options;
	}

	@Override
	protected int getPort() {

		return DEFAULT_PORT;
	}

	@Override
	protected LoadBalancingPolicy getLoadBalancingPolicy() {

		return super.getLoadBalancingPolicy();
	}

	@Override
	protected String getContactPoints() {

		return DEFALUT_CONNECTION_POINTS;
	}

	@Override
	public SchemaAction getSchemaAction() {
		// TODO configure for first run
		return SchemaAction.RECREATE_DROP_UNUSED;
	}
	@Override
	public String[] getEntityBasePackages() {
		return new String[] { "domain" };
	}
	
	
	
	
	
		
		

	
}
