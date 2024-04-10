package fr.fms.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Article implements Serializable {
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	private double price;
}
