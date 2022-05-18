package com.example.plantsforyou.cart;


import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.plant.Plant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    private Plant plant;
    @JsonIgnore
    @OneToOne(targetEntity = AppUser.class)
    private AppUser appUser;

    private int quantity;



    public Cart(Plant plant, Integer quantity, AppUser appUser) {
        this.plant = plant;
        this.appUser = appUser;
        this.quantity = quantity;
        this.createdDate = new Date();
    }
}
