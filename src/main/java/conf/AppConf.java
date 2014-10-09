/**
 * 
 */
package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.AppRunBean;

/**
 * @author arpan
 *
 */
@Configuration
public class AppConf {

	@Bean
	AppRunBean appRunBean()
	{
		return new AppRunBean();
	}
	
	
	

}
