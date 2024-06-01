package com.Lakkam.order_service.Repository;

import com.Lakkam.order_service.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepsoitory extends JpaRepository<Order,Long> {
}
