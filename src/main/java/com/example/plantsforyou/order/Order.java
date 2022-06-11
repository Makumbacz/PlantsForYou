package com.example.plantsforyou.order;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.items_order.ItemOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    //todo: validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String postalCode;

    private String street;

    private String city;

    private String phoneNumber;

    private Date createdDate;

    private double totalPrice;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;
    @OneToMany(mappedBy = "order")
    private List<ItemOrder> itemsOrders;
    private String status;

    public Order(String postalCode, String street, String city, String phoneNumber, double totalPrice, AppUser appUser, List<ItemOrder> itemsOrders, String status) {
        this.postalCode = postalCode;
        this.street = street;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.createdDate = new Date();
        this.totalPrice = totalPrice;
        this.appUser = appUser;
        this.itemsOrders = itemsOrders;
        this.status = status;
    }
}
