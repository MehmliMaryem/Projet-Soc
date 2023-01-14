package com.itmsd.Services.repositories;



import com.itmsd.Services.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit, Long> {

}
