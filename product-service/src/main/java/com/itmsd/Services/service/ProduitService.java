package com.itmsd.Services.service;


import com.itmsd.Services.dto.ProduitRequest;
import com.itmsd.Services.dto.ProduitResponse;
import com.itmsd.Services.entities.Produit;
import com.itmsd.Services.repositories.ProduitRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j

public class ProduitService {


    private static final ProduitRepo produitRepo = null;


    public void createProduit(ProduitRequest produitRequest) {
        Produit produit = Produit.builder()
                .name(produitRequest.getName())
                .description(produitRequest.getDescription())
                .price(produitRequest.getPrice())
                .build();
        produitRepo.save(produit);
        log.info("produit {} enregistré :) !! ", produit.getId());
    }

    public static List<Object> getAllProduits() {
        List<Produit> produits = produitRepo.findAll();

        return produits.stream().map(produit -> mapToProduitResponse(produit)).collect(Collectors.toList());

    }

    private static ProduitResponse mapToProduitResponse(Produit produit) {
        return ProduitResponse.builder()
                .id(produit.getId())
                .name(produit.getName())
                .description(produit.getDescription())
                .price(produit.getPrice())
                .build();

    }
}