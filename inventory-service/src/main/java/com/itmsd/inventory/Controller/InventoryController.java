package com.itmsd.inventory.Controller;

import com.itmsd.inventory.dto.InventoryResponse;
import com.itmsd.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private  final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //ki ijiiw plusieur code fl url donc nbadlouha list of code
    public List<InventoryResponse> isInStock(@RequestParam List<String> code){

        return inventoryService.isInStock(code);
    }

}
