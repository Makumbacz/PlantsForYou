package com.example.plantsforyou.cart;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.appuser.AppUserService;
import com.example.plantsforyou.dto.CartDto;
import com.example.plantsforyou.dto.ItemCartDto;
import com.example.plantsforyou.exceptions.RejectedRequestException;
import com.example.plantsforyou.plant.Plant;
import com.example.plantsforyou.plant.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {
    private final CartService cartService;
    private final PlantService plantService;
    private final AppUserService appUserService;

    @Autowired
    public CartController(CartService cartService, PlantService plantService, AppUserService appUserService) {
        this.cartService = cartService;
        this.plantService = plantService;
        this.appUserService = appUserService;
    }

    @PostMapping
    public ResponseEntity<Object> addToCart(@RequestBody ItemCartDto itemCartDto) throws RejectedRequestException {
        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").substring("Bearer ".length());
        AppUser appUser = appUserService.getUserFromToken(token);
        Plant plant = plantService.findPlantById(itemCartDto.getId());
        cartService.addToCart(itemCartDto, plant, appUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
