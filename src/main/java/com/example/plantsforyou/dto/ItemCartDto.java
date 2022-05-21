package com.example.plantsforyou.dto;

import com.example.plantsforyou.cart.Cart;
import com.example.plantsforyou.plant.Plant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemCartDto {
    private Long id;
    private Plant plant;
    private Integer quantity;

    public ItemCartDto(Cart cart){
        this.id = getId();
        this.plant = getPlant();
        this.quantity = getQuantity();
    }
}
