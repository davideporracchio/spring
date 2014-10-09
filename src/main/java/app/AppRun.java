/**
 * 
 */
package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author arpan
 *
 */
public class AppRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext("conf");

		AppRunBean bean =  ctx.getBean(AppRunBean.class);
		bean.run();

	}

}
