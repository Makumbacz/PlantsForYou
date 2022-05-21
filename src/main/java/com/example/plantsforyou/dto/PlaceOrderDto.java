package com.example.plantsforyou.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class PlaceOrderDto {
    //todo: validation
    private String phoneNumber;
    private String postalCode;
    private String street;
    private String city;


}
