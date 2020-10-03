package com.japari.onlineorder;



import com.japari.onlineorder.repository.FoodRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableCaching
public class OnlineorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineorderApplication.class, args);


	}
}

//@Slf4j
//@EnableTransactionManagement
//@SpringBootApplication
//@EnableJpaRepositories
//public class OnlineorderApplication implements ApplicationRunner {
//
//	@Autowired
//	private FoodRepository coffeeRepository;
//	@Autowired
//	private FoodService coffeeService;
//	@Autowired
//	private FoodOrderService orderService;
//
//	public static void main(String[] args) {
//		SpringApplication.run(OnlineorderApplication.class, args);
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		log.info("All Coffee: {}", coffeeRepository.findAll());
//
//		Optional<Food> latte = coffeeService.findOneFood("Latte");
//		if (latte.isPresent()) {
//			FoodOrder order = orderService.createOrder("Li Lei", latte.get());
//			log.info("Update INIT to PAID: {}", orderService.updateState(order, OrderState.PAID));
//			log.info("Update PAID to INIT: {}", orderService.updateState(order, OrderState.INIT));
//		}
//	}
//}

