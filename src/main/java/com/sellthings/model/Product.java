package com.sellthings.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "sku")
	private String sku;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	@Column(name = "units_in_stock")
	private BigDecimal unitsInStock;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "active")
	private boolean active;
	
	@CreationTimestamp
	@Column(name = "date_created")
	private LocalDate dateCreated;
	
	@UpdateTimestamp
	@Column(name = "last_updated")
	private LocalDate lastUpdated;
	
    @ManyToOne
    @JoinColumn(name ="category_id", nullable = false)
	private ProductCategory category;
}
