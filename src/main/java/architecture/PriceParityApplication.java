package architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

//@EnableEurekaServer
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableScheduling
public class PriceParityApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PriceParityApplication.class, args);
	}


}
