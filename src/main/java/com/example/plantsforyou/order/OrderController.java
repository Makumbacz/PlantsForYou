package com.example.plantsforyou.order;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.appuser.AppUserService;
import com.example.plantsforyou.cart.CartService;
import com.example.plantsforyou.dto.PlaceOrderDto;
import com.example.plantsforyou.dto.UpdateOrderDto;
import com.example.plantsforyou.exceptions.RejectedRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Controller
@RequestMapping("api/v1/order")
public class OrderController {

    private final AppUserService appUserService;
    private final CartService cartService;
    private final OrderService orderService;


    public OrderController(AppUserService appUserService, CartService cartService, OrderService orderService) {
        this.appUserService = appUserService;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<Object>placeOrder(@RequestBody PlaceOrderDto placeOrderDto) throws RejectedRequestException {
        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").substring("Bearer ".length());
        AppUser appUser = appUserService.getUserFromToken(token);
        orderService.placeOrder(placeOrderDto,appUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<Order>>getAllOrdersFromUser(){
        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").substring("Bearer ".length());
        AppUser appUser = appUserService.getUserFromToken(token);
        return new ResponseEntity<>(orderService.getAllOrdersFromUserId(appUser.getId()), HttpStatus.OK);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Order>getOrderById(@PathVariable("orderId") Long id){
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<Object>editOrderById(@RequestBody UpdateOrderDto updateOrderDto, @PathVariable("orderId") Long id) throws RejectedRequestException {
        orderService.editOrderById(updateOrderDto,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrdersFromBase(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
    @GetMapping("/all/id")
    public ResponseEntity<List<Long>> getAllOrderIdsFromBase(){
        return new ResponseEntity<>(orderService.getAllOrdersIds(), HttpStatus.OK);
    }

}
