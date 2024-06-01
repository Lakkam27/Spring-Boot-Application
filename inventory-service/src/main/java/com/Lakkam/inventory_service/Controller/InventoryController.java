package com.Lakkam.inventory_service.Controller;

import com.Lakkam.inventory_service.Model.InventoryResponse;
import com.Lakkam.inventory_service.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    public List<InventoryResponse> inStock(@RequestParam List<String> skuCode) {
        return  inventoryService.isInStock(skuCode);

    }
}
