package com.Lakkam.inventory_service.Service;

import com.Lakkam.inventory_service.Model.Inventory;
import com.Lakkam.inventory_service.Model.InventoryResponse;
import com.Lakkam.inventory_service.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory -> InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0).build()).toList();
    }
}
