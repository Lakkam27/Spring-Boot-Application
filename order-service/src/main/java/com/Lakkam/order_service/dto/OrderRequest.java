package com.Lakkam.order_service.dto;

import com.Lakkam.order_service.Model.OrderLineItem;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    List<OrderLineItemDto> orderLineItemDtoList;
}
