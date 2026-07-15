package com.app.ecom.Controller;


import com.app.ecom.dto.CartItemRequest;
import com.app.ecom.model.CartItem;
import com.app.ecom.service.cartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final cartService cartService;

    @PostMapping
    public ResponseEntity<String> addToCart(
            @RequestHeader("X-User-ID") String userId,
            @RequestBody CartItemRequest request)

    {

       if(!cartService.addToCart(userId, request))
        {
            return ResponseEntity.badRequest().body("Product Out of staoc or user not found or product not found ");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/items/{productId}")
    public ResponseEntity<Void> removeFromCart(
            @RequestHeader("X-User-ID")   String userId,
            @PathVariable Long productId
    )
    {
          boolean deleted=   cartService.deleteItemFromCart(userId,productId);
          return deleted? ResponseEntity.noContent().build(): ResponseEntity.notFound().build();

    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getCart(
            @RequestHeader("X-User-ID")   String userId
    )
    {

        return ResponseEntity.ok(cartService.getCart(userId));

    }
}

//4:58