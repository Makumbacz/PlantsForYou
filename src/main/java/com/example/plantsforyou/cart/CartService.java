package com.example.plantsforyou.cart;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.dto.CartDto;
import com.example.plantsforyou.dto.AddToCartDto;
import com.example.plantsforyou.dto.ItemCartDto;
import com.example.plantsforyou.exceptions.RejectedRequestException;
import com.example.plantsforyou.plant.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(AddToCartDto addToCartDto, Plant plant, AppUser appUser) throws RejectedRequestException {
        if(cartRepository.findByPlantAndAppUser(plant,appUser).isPresent()){
            throw new RejectedRequestException("Plant is already in a cart", HttpStatus.BAD_REQUEST);
        }
        if(addToCartDto.getAmountInBasket() > plant.getQuantity()){
            throw new RejectedRequestException("You can not order more plants than we have in stock", HttpStatus.BAD_REQUEST);

        }
        Cart cart = new Cart(plant,addToCartDto.getAmountInBasket(),appUser);
        cartRepository.save(cart);
    }

    public CartDto getAllItemsFromCart(AppUser appUser){
        List<Cart> cartList = cartRepository.findAllByAppUserOrderByCreatedDate(appUser);
        List<ItemCartDto> itemCartDto = new ArrayList<>();
        double totalPrice = 0.0;
        for (Cart cart: cartList) {
            ItemCartDto itemCartDtoTemp = getDtoFromCart(cart);
            itemCartDto.add(itemCartDtoTemp);
            totalPrice += itemCartDtoTemp.getPlant().getPrice() * itemCartDtoTemp.getQuantity();
        }

        return new CartDto(itemCartDto,totalPrice);
    }

    private ItemCartDto getDtoFromCart(Cart cart) {
        return new ItemCartDto(cart);
    }

    public void deleteItemsFromCart(AppUser appUser){
         cartRepository.deleteByAppUser(appUser);
    }
}
