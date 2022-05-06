package com.example.plantsforyou.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class AddToCartDto {
    Long id;
    private @NotNull Long plantId;
    private @NotNull Integer quantity;
}
