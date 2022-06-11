package com.example.plantsforyou.order;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.appuser.AppUserService;
import com.example.plantsforyou.cart.CartService;
import com.example.plantsforyou.dto.PlaceOrderDto;
import com.example.plantsforyou.exceptions.RejectedRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrdersFromBase(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }


}
