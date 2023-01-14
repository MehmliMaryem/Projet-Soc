package com.itmsd.ordre.controller;

import com.itmsd.ordre.dto.OrdreRequest;
import com.itmsd.ordre.model.Order;
import com.itmsd.ordre.repository.OrderRepo;
import com.itmsd.ordre.service.OrdreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ordre")
@AllArgsConstructor
public class OrdreController {
    private final OrdreService ordreService;
  @Autowired
  private OrderRepo orderRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
  /*  public Order createOrder(@Valid @RequestBody Order order) {
        return orderRepo.save(order);
    }*/

     public String placeOrdre(@RequestBody OrdreRequest ordreRequest){
     ordreService.placeOrdre(ordreRequest);
     return "ordre placée";
    }

}
