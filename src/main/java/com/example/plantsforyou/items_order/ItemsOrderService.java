package com.example.plantsforyou.items_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsOrderService {
    private ItemsOrderRepository itemsOrderRepository;

    @Autowired
    public ItemsOrderService(ItemsOrderRepository itemsOrderRepository) {
        this.itemsOrderRepository = itemsOrderRepository;
    }
}
