package com.itmsd.inventory.service;

import com.itmsd.inventory.dto.InventoryResponse;
import com.itmsd.inventory.Repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepo inventoryRepo;

@Transactional (readOnly=true ) //validé et fermé apres l appel de la methode
    public List<InventoryResponse> isInStock(List<String> code){
       return inventoryRepo.findByCodeIn(code).stream()
               .map(inventory ->
                   InventoryResponse.builder()
                           .code(inventory.getCode())
                           .isInStock(inventory.getQuantity()>0)
                           .build())
               .collect(Collectors.toList());

    }

}
