package com.example.plantsforyou.cart;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.dto.AddToCartDto;
import com.example.plantsforyou.plant.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(AddToCartDto addToCartDto, Plant plant,AppUser appUser) {
        Cart cart = new Cart(plant,addToCartDto.getQuantity(),appUser);
        cartRepository.save(cart);
    }
}
