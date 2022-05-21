package com.example.plantsforyou.items_order;


import com.example.plantsforyou.order.Order;
import com.example.plantsforyou.plant.Plant;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class ItemOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @NotNull
    private double price;
    @OneToOne
    @JoinColumn/*(name = "plant_id", referencedColumnName = "id")*/
    private Plant plant;
    @ManyToOne
    @JoinColumn/*(name = "order_id", referencedColumnName = "id")*/
    private Order order;
    @NotNull
    private Integer quantity;

    public ItemOrder(Integer price, Plant plant, Order order, Integer quantity) {
        this.date = new Date();
        this.price = price;
        this.plant = plant;
        this.order = order;
        this.quantity = quantity;
    }
}
