package io.shaikezam.orderservice.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Order {
    private Long id;
    private Double price;
    private Date purchaseTimestamp;

    public Order(Double price) {
        this.price = price;
    }
}
