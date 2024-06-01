package com.Lakkam.order_service.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.IdGeneratorType;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderNumber;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItemList;
}
