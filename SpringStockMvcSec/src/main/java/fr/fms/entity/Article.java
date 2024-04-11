package fr.fms.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Article implements Serializable {
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=3,max=50)
	private String description;
	@DecimalMin("0.10")
	private double price;
}