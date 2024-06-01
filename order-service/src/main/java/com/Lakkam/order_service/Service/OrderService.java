package com.Lakkam.order_service.Service;

import com.Lakkam.order_service.Model.Order;
import com.Lakkam.order_service.Model.OrderLineItem;
import com.Lakkam.order_service.Repository.OrderRepsoitory;
import com.Lakkam.order_service.dto.InventoryResponse;
import com.Lakkam.order_service.dto.OrderLineItemDto;
import com.Lakkam.order_service.dto.OrderRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {
    private final WebClient webClient;
    private final OrderRepsoitory orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        if (orderRequest == null || orderRequest.getOrderLineItemDtoList() == null) {
            log.error("Order request or order line item list is null.");
            return;
        }

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItemDto> orderLineItemDtoList = orderRequest.getOrderLineItemDtoList();
        List<OrderLineItem> orderLineItemList = new ArrayList<>();
        for (OrderLineItemDto orderLineItemDto : orderLineItemDtoList) {
            orderLineItemList.add(mapToEntity(orderLineItemDto, order));
        }
        order.setOrderLineItemList(orderLineItemList);
        List<String> skuCodes = order.getOrderLineItemList()
                .stream().map(OrderLineItem::getSkuCode).
                toList();

        InventoryResponse[] inventoryResponses=webClient.get().uri("https://localhost:8081/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                        .block();
        boolean allProductInStock=Arrays.stream(inventoryResponses).allMatch(inventoryResponse -> inventoryResponse.isInStock());
        if(allProductInStock){
        orderRepository.save(order);
        }else{
                throw new IllegalArgumentException("Product your are looking is not available! ");
        }
    }

    private OrderLineItem mapToEntity(OrderLineItemDto orderLineItemDto, Order order) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setOrder(order);
        orderLineItem.setPrice(orderLineItemDto.getPrice());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());
        orderLineItem.setSkuCode(orderLineItemDto.getSkuCode());
        return orderLineItem;
    }
public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
