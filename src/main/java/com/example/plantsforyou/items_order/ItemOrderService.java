package com.example.plantsforyou.items_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderService {
    private ItemOrderRepository itemOrderRepository;

    @Autowired
    public ItemOrderService(ItemOrderRepository itemsOrderRepository) {
        this.itemOrderRepository = itemsOrderRepository;
    }


}
