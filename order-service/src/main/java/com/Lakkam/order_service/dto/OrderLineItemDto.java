package com.Lakkam.order_service.dto;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLineItemDto {
    private long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
