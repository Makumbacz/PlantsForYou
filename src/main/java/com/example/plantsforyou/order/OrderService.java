package com.example.plantsforyou.order;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.cart.CartService;
import com.example.plantsforyou.dto.CartDto;
import com.example.plantsforyou.dto.ItemCartDto;
import com.example.plantsforyou.dto.PlaceOrderDto;
import com.example.plantsforyou.dto.UpdateOrderDto;
import com.example.plantsforyou.exceptions.RejectedRequestException;
import com.example.plantsforyou.items_order.ItemOrder;
import com.example.plantsforyou.items_order.ItemOrderRepository;
import com.example.plantsforyou.plant.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final ItemOrderRepository itemOrderRepository;
    private final PlantService plantService;

    public OrderService(OrderRepository orderRepository, CartService cartService, ItemOrderRepository itemOrderRepository, PlantService plantService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.itemOrderRepository = itemOrderRepository;
        this.plantService = plantService;
    }

    public Long placeOrder(PlaceOrderDto placeOrderDto, AppUser appUser) throws RejectedRequestException {
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

            plantService.updateQuantity(itemCartDto.getPlant().getId(),-(itemCartDto.getQuantity()));
        }

        cartService.deleteItemsFromCart(appUser);
        return order.getId();

    }
    List<Order> getAllOrdersFromUserId(Long id){
        return orderRepository.findAllByAppUserIdOrderByCreatedDateDesc(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void editOrderById(UpdateOrderDto updateOrderDto, Long id) throws RejectedRequestException {
        if(!orderRepository.existsById(id)){
            throw new RejectedRequestException("Order does not exist", HttpStatus.BAD_REQUEST);
        }
        Order order = orderRepository.getById(id);

        order.setStatus(updateOrderDto.getStatus());
        orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    public List<Long> getAllOrdersIds() {
        return orderRepository.findAllId();
    }
}
