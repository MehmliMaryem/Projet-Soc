package com.itmsd.Services.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Produit")
@Data
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
 	private String name ;
 	private String description ;
 	private BigDecimal price;
//	private  Byte[] photos;
}