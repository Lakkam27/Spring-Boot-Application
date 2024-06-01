package com.Lakkam.inventory_service;

import com.Lakkam.inventory_service.Model.Inventory;
import com.Lakkam.inventory_service.Repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            // Initialize data here if needed
            inventoryRepository.save(new Inventory(null, "samsung", 100));
            inventoryRepository.save(new Inventory(null, "apple", 0));
        };
    }
}
