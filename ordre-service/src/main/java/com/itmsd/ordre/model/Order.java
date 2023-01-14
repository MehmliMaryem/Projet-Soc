package com.itmsd.ordre.model;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "ordre")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String NumOrdre;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrdreLineItems> ordreLineItemsList;

}
