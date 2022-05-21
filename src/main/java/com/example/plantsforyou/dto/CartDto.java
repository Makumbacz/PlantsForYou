package com.example.plantsforyou.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class CartDto {
    List<ItemCartDto> plantsInCart;
    Double totalCost;

    public CartDto(List<ItemCartDto> plantsInCart, Double totalCost) {
        this.plantsInCart = plantsInCart;
        this.totalCost = totalCost;
    }
}
