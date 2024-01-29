package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.CartItem;


@RestController
@RequestMapping("/cart")
public class CartController {
	 private final CartService cartService;

	    @Autowired
	    public CartController(CartService cartService) {
	        this.cartService = cartService;
	    }

	    @PostMapping("/addProduct")
	    public void addProductToCart(@RequestParam Long productId, @RequestParam int quantity) {
	        cartService.addProductToCart(productId, quantity);
	    } @GetMapping("/allcart")
		  public ResponseEntity<List<CartItem>> viewAllCartProducts()
		  {
			  return new ResponseEntity<>(cartService.getAllproductsincart(),HttpStatus.OK);
		  }
		  @DeleteMapping("/removeProduct/{cartItemId}")
		    public ResponseEntity<String> removeProductFromCartItem(@PathVariable Long cartItemId) {
		        String result = cartService.removeProductFromCartItem(cartItemId);
		        return ResponseEntity.ok(result);
		  }

}
