package com.itmsd.inventory;

import com.itmsd.inventory.Model.Inventory;
import com.itmsd.inventory.Repo.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
public class InventoryApplication {

	public static void main(String[] args) {SpringApplication.run(InventoryApplication.class, args);}

	@Bean
	public CommandLineRunner loadData(InventoryRepo inventoryRepo){
    return args ->{
	Inventory inventory1 = new Inventory();
	inventory1.setCode("airpods");
	inventory1.setQuantity(50);

	Inventory inventory2 = new Inventory();
	inventory2.setCode("ecouteurs");
	inventory2.setQuantity(0);
	inventoryRepo.save(inventory1);
	inventoryRepo.save(inventory2);

            };
	}
}
