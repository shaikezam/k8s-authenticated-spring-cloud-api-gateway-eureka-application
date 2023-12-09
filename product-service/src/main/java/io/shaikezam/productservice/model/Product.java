package io.shaikezam.productservice.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
}
