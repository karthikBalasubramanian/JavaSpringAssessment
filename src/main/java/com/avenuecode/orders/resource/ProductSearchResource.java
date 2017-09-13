package com.avenuecode.orders.resource;

import com.avenuecode.orders.domain.Product;
import com.avenuecode.orders.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/productSearch")
public class ProductSearchResource {

    @Autowired
    ProductService productService;

    @GetMapping("/{price}")
    public ResponseEntity<List<Product>> getCostlyProducts(@PathVariable int price) {

        List<Product> productsList = productService.listProducts();
        ArrayList<Product> filteredProducts = new ArrayList<Product>();
        if (price < 0) return ok(productsList);
        else {
            for (Product product : productsList) {
                if (product.getPrice().intValue() > price) {
                    filteredProducts.add(product);
                }
            }

            return ok(filteredProducts);
        }
    }


}
