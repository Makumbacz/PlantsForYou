package com.example.plantsforyou.cart;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.plant.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByPlantAndAppUser(Plant plant, AppUser appUser);
    List<Cart> findAllByAppUserOrderByCreatedDate(AppUser appUser);
    void deleteByAppUser(AppUser appUser);
}
