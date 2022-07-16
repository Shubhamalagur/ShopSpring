package com.oliver.shopSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.oliver.shopSpring.entity.OrderEntity;
import com.oliver.shopSpring.entity.UserEntity;
import com.oliver.shopSpring.entity.enums.OrderStatus;
import com.oliver.shopSpring.repository.OrderRepsitory;
import com.oliver.shopSpring.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	private final UserRepository userRepository;
	private final OrderRepsitory orderRepsitory;

	public TestConfig(UserRepository userRepository, OrderRepsitory orderRepsitory) {
		this.userRepository = userRepository;
		this.orderRepsitory = orderRepsitory;
	}

	@Override
	public void run(String... args) throws Exception {

		UserEntity u1 = new UserEntity( "Maria Brown", "maria@gmail.com", "988888888", "123456");
		UserEntity u2 = new UserEntity( "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
		OrderEntity o1 = new OrderEntity(null, Instant.parse("2022-06-20T19:53:07Z"),OrderStatus.PAGO, u1);
		OrderEntity o2 = new OrderEntity(null, Instant.parse("2022-07-21T03:42:10Z"),OrderStatus.ESPERANDO_PAGAMENTO, u2);
		OrderEntity o3 = new OrderEntity(null, Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.ESPERANDO_PAGAMENTO,u1); 
		
		orderRepsitory.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
	
	
	

}
