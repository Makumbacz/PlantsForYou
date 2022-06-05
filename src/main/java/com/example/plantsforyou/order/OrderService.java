package com.example.plantsforyou.order;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.cart.CartService;
import com.example.plantsforyou.dto.CartDto;
import com.example.plantsforyou.dto.ItemCartDto;
import com.example.plantsforyou.dto.PlaceOrderDto;
import com.example.plantsforyou.items_order.ItemOrder;
import com.example.plantsforyou.items_order.ItemOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private final CartService cartService;
    private final ItemOrderRepository itemOrderRepository;

    public OrderService(OrderRepository orderRepository, CartService cartService, ItemOrderRepository itemOrderRepository) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.itemOrderRepository = itemOrderRepository;
    }

    public void placeOrder(PlaceOrderDto placeOrderDto, AppUser appUser) {
        CartDto cartDto = cartService.getAllItemsFromCart(appUser);
        List<ItemCartDto> itemCartDtos = cartDto.getPlantsInCart();

        Order order = new Order();
        order.setAppUser(appUser);
        order.setCity(placeOrderDto.getCity());
        order.setCreatedDate(new Date());
        order.setPhoneNumber(placeOrderDto.getPhoneNumber());
        order.setPostalCode(placeOrderDto.getPostalCode());
        order.setTotalPrice(cartDto.getTotalCost());
        order.setStreet(placeOrderDto.getStreet());
        order.setStatus("Waiting for payment");
        orderRepository.save(order);

        for (ItemCartDto itemCartDto:
             itemCartDtos) {
            ItemOrder itemOrder = new ItemOrder();
            itemOrder.setDate(new Date());
            itemOrder.setPrice(itemCartDto.getPlant().getPrice());
            itemOrder.setPlant(itemCartDto.getPlant());
            itemOrder.setQuantity(itemCartDto.getQuantity());
            itemOrder.setOrder(order);
            itemOrderRepository.save(itemOrder);
        }

  //      cartService.deleteItemsFromCart(appUser);

    }
    List<Order> getAllOrdersFromUserId(Long id){
        return orderRepository.findAllByAppUserIdOrderByCreatedDateDesc(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
