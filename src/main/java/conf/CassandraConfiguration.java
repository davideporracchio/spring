/**
 * 
 */
package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;

/**
 * @author arpan
 * 
 */
@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	private static final String KEY_NAME = "mykeyspace";

	@Override
	protected String getKeyspaceName() {

		return KEY_NAME;
	}

	@Bean(name="casops")	
	public CassandraOperations operatrions() throws Exception {

		return new CassandraTemplate(session().getObject(), new MappingCassandraConverter(new BasicCassandraMappingContext()));
	}

}
