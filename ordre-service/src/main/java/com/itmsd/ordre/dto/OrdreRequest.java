package com.itmsd.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdreRequest {
    private List<OrdreLineItemsDto> ordreLineItemsDtoList;


}
