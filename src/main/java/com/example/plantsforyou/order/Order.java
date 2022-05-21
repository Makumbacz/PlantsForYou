package com.example.plantsforyou.order;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.items_order.ItemOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
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
    @JoinColumn
    private AppUser appUser;

    @OneToMany
    @ToString.Exclude
    private List<ItemOrder> itemsOrders;

    private String status;


}
