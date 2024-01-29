package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Cart;
import com.example.Entity.CartItem;
import com.example.Entity.Product;
import com.example.Repository.CaritenRepository;
import com.example.Repository.CartRepository;
import com.example.Repository.ProductRepository;

@Service
public class CartImpl implements CartService {

	private final CartRepository cartRepositary ;
    private final CaritenRepository cartItemRepository;
    private final ProductRepository productRepository ;
    
    @Autowired
    public CartImpl(CartRepository cartRepositary, CaritenRepository cartItemRepository,
			ProductRepository productRepository) {
		this.cartRepositary = cartRepositary;
		this.cartItemRepository = cartItemRepository;
		this.productRepository = productRepository;
	}
    public boolean isProductInCart(Long productId) {
        return cartItemRepository.existsByProductId(productId);
    }
 // Implement methods to add products to the cart, update quantities.
    public String addProductToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            Optional<CartItem> optionalCartItem = cartItemRepository.findByProductId(productId);

            if (optionalCartItem.isPresent()) {
                // Product already exists in the cart, update quantity
                CartItem cartItem = optionalCartItem.get();
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItemRepository.save(cartItem);
                return "Successfully updated product quantity in cart";
            } else {
                // Product not in the cart, create a new Cart and add the product
                Cart cart = new Cart();
                CartItem cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setQuantity(quantity);
                cartItem.setCart(cart); // Associate the cart with the cart item
                cartItemRepository.save(cartItem);
                return "Successfully added new product to cart";
            }
        } else {
            return "Product not found";
        }
    }
    @Override
    public String removeProductFromCartItem(Long cartItemId) {
        if (cartItemRepository.existsById(cartItemId)) {
            cartItemRepository.deleteById(cartItemId);
            return "Successfully removed product from cart item";
        } else {
            return "Product not found in cart item";
        }
    }
	@Override
	public List<CartItem> getAllproductsincart() {
		// TODO Auto-generated method stub
		return cartItemRepository.findAll();
	}
	
}


