package com.example.plantsforyou.cart;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.dto.CartDto;
import com.example.plantsforyou.dto.ItemCartDto;
import com.example.plantsforyou.exceptions.RejectedRequestException;
import com.example.plantsforyou.plant.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(ItemCartDto itemCartDto, Plant plant, AppUser appUser) throws RejectedRequestException {
        if(cartRepository.findByPlantAndAppUser(plant,appUser).isPresent()){
            throw new RejectedRequestException("Plant is already in a cart", HttpStatus.BAD_REQUEST);
        }
        Cart cart = new Cart(plant,itemCartDto.getAmountInBasket(),appUser);
        cartRepository.save(cart);
    }

}
