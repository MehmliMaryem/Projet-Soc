package com.itmsd.Services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProduitResponse {
    private Long id;
    private String name ;
    private String description ;
    private BigDecimal price;
  //  private  Byte[] photos;
}
