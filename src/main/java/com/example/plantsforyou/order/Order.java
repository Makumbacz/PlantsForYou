package com.example.plantsforyou.order;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.items_order.ItemsOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String status;
    private String phoneNumber;
    @OneToOne
    @JoinColumn
    private AppUser appUser;
    @OneToMany
    private List<ItemsOrder> itemsOrders;
    private Integer totalPrice;


}
