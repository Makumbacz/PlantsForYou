package com.example.plantsforyou.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class AddAllToCartDto {
    @JsonProperty("products")
    private List<AddToCartDto> addToCartDtoList;

}
