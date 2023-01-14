package com.itmsd.Services.Controller;


import com.itmsd.Services.dto.ProduitRequest;
import com.itmsd.Services.entities.Produit;
import com.itmsd.Services.repositories.ProduitRepo;
import com.itmsd.Services.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/produit")
@CrossOrigin ( origins = "*" )
@RequiredArgsConstructor
public class ProduitController {

 private final ProduitService produitService;
 @Autowired
 private ProduitRepo produitRepo;
/*
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public void createProduit(@RequestBody ProduitRequest produitRequest){
    produitService.createProduit(produitRequest);
 }*/

 @PostMapping
 Produit createproduit(@Valid @RequestBody Produit produit) {
  return produitRepo.save(produit);
 }


 @GetMapping
 @ResponseStatus(HttpStatus.OK)
 public List<Produit> getAllProduits() {
  return (List<Produit>) produitRepo.findAll();
 }
 /*
 public List<Object> getAllProduit(){
  return  ProduitService.getAllProduits();


 }  */
 /*

 @PutMapping("/edit")
 public ResponseEntity<Appartement> updateAppartement(@Valid @RequestBody Appartement appartement) {
  Appartement result = appartementRepo.save(appartement);
  return ResponseEntity.ok().body(result);
 }
 @GetMapping("/countappartement")
 public Long countappartement() {
  return appartementRepo.count();
 }*/

}
