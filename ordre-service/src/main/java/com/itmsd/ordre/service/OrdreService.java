package com.itmsd.ordre.service;

import com.itmsd.ordre.dto.InventoryResponse;
import com.itmsd.ordre.dto.OrdreLineItemsDto;
import com.itmsd.ordre.dto.OrdreRequest;
import com.itmsd.ordre.model.Order;
import com.itmsd.ordre.model.OrdreLineItems;
import com.itmsd.ordre.repository.OrderRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class OrdreService {

   private  final OrderRepo orderRepo;
   private final WebClient.Builder webClientBuilder;

    public void placeOrdre(OrdreRequest ordreRequest){
        Order ordre= new Order();
        ordre.setNumOrdre(UUID.randomUUID().toString());

        List<OrdreLineItems> ordreLineItems=
        ordreRequest.getOrdreLineItemsDtoList()
                .stream()
                .map(ordreLineItemsDto -> mapToDto(ordreLineItemsDto))
                .collect(Collectors.toList());
        ordre.setOrdreLineItemsList(ordreLineItems);

        List<String> Codes = ordre.getOrdreLineItemsList()
                .stream()
                .map(OrdreLineItems::getCode)
                .collect(Collectors.toList());

        //call inventory service and place ordre( s il y a un produit)
 //8111
       InventoryResponse[] inventoryResponsArray= webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder ->uriBuilder.queryParam("code",Codes).build() )
                        .retrieve()
                                    .bodyToMono(InventoryResponse[].class)
                                        .block();
     boolean allProductsInStock=  Arrays.stream(inventoryResponsArray).allMatch(inventoryResponse -> inventoryResponse.isInStock());
     if(allProductsInStock){
          orderRepo.save(ordre);
      }else {
          throw new IllegalArgumentException("le produit n est pas en stock");
      }

        orderRepo.save(ordre);

    }

    private OrdreLineItems mapToDto(OrdreLineItemsDto ordreLineItemsDto) {
      OrdreLineItems ordreLineItems= new OrdreLineItems();
      ordreLineItems.setPrice(ordreLineItemsDto.getPrice());
      ordreLineItems.setQuantity(ordreLineItemsDto.getQuantity());
      ordreLineItems.setCode(ordreLineItemsDto.getCode());
      return ordreLineItems;
    }
}
