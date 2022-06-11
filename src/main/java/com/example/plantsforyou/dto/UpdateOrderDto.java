package com.example.plantsforyou.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateOrderDto {

    private String firstName;

    private String lastName;

    private String email;

    private String postalCode;

    private String street;

    private String city;

    private String phoneNumber;

    private String status;
}
