package com.itmsd.inventory.Repo;

import com.itmsd.inventory.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByCode(String code);

    List<Inventory> findByCodeIn(List<String> code);
}
