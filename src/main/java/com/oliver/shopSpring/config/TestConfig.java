package com.oliver.shopSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.oliver.shopSpring.entity.CategoryEntity;
import com.oliver.shopSpring.entity.OrdemItem;
import com.oliver.shopSpring.entity.OrderEntity;
import com.oliver.shopSpring.entity.ProductEntity;
import com.oliver.shopSpring.entity.UserEntity;
import com.oliver.shopSpring.entity.enums.OrderStatus;
import com.oliver.shopSpring.repository.CategoryRepsitory;
import com.oliver.shopSpring.repository.OrdemItemRepository;
import com.oliver.shopSpring.repository.OrderRepsitory;
import com.oliver.shopSpring.repository.ProductRepository;
import com.oliver.shopSpring.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	private final UserRepository userRepository;
	private final OrderRepsitory orderRepsitory;
	private final CategoryRepsitory categoriaRepsitory;
	private final ProductRepository productRepsitory;
	private final OrdemItemRepository ordemItemRepositor;

	public TestConfig(UserRepository userRepository, OrderRepsitory orderRepsitory, CategoryRepsitory 
			categoriaRepsitory,ProductRepository productRepsitory, OrdemItemRepository ordemItemRepositor) {
		this.userRepository = userRepository;
		this.orderRepsitory = orderRepsitory;
		this.categoriaRepsitory = categoriaRepsitory;
		this.productRepsitory = productRepsitory;
		this.ordemItemRepositor = ordemItemRepositor;
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoryEntity cat1 = new CategoryEntity(null, "Electronics");
		CategoryEntity cat2 = new CategoryEntity(null, "Books");
		CategoryEntity cat3 = new CategoryEntity(null, "Computers"); 
		
		categoriaRepsitory.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		ProductEntity p1 = new ProductEntity(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		ProductEntity p2 = new ProductEntity(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		ProductEntity p3 = new ProductEntity(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		ProductEntity p4 = new ProductEntity(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		ProductEntity p5 = new ProductEntity(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productRepsitory.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		//--n:n
				p1.getCategorias().add(cat2);
				p2.getCategorias().add(cat1);
				p2.getCategorias().add(cat3);
				p3.getCategorias().add(cat3);
				p4.getCategorias().add(cat3);
				p5.getCategorias().add(cat2);

				productRepsitory.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		//---

		
		UserEntity u1 = new UserEntity( "Maria Brown", "maria@gmail.com", "988888888", "123456");
		UserEntity u2 = new UserEntity( "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
		OrderEntity o1 = new OrderEntity(null, Instant.parse("2022-06-20T19:53:07Z"),OrderStatus.PAGO, u1);
		OrderEntity o2 = new OrderEntity(null, Instant.parse("2022-07-21T03:42:10Z"),OrderStatus.ESPERANDO_PAGAMENTO, u2);
		OrderEntity o3 = new OrderEntity(null, Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.ESPERANDO_PAGAMENTO,u1); 
		
		orderRepsitory.saveAll(Arrays.asList(o1,o2,o3));
		
		
		//n:n com tabela com dados extras e chave composta
		OrdemItem oi1 = new OrdemItem(o1, p1, 2, p1.getPreco());
		OrdemItem oi2 = new OrdemItem(o1, p3, 1, p3.getPreco());
		OrdemItem oi3 = new OrdemItem(o2, p3, 2, p3.getPreco());
		OrdemItem oi4 = new OrdemItem(o3, p5, 2, p5.getPreco());
		
		ordemItemRepositor.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}
	
	
	
	

}
