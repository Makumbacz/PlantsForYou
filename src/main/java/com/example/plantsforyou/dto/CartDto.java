package com.example.plantsforyou.dto;

import com.example.plantsforyou.plant.Plant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class CartDto {
    List<ItemCartDto> plantsInCart;
    double totalCost;
}
