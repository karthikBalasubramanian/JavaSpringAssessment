package com.avenuecode.orders.resourceTest;

import com.avenuecode.orders.domain.Product;
import com.avenuecode.orders.resource.ProductSearchResource;
import com.avenuecode.orders.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductSearchResourceTest {

    @Autowired
    ProductSearchResource productSearchResource;

    @Autowired
    ProductService productService;

    @Test
    public void getCostlyProducts() throws Exception {

        ResponseEntity<List<Product>> costlyProducts;
        costlyProducts =  productSearchResource.getCostlyProducts(-2);
        assertEquals(productService.listProducts().size(),costlyProducts.getBody().size());
        costlyProducts =  productSearchResource.getCostlyProducts(20);
        assertEquals(4,costlyProducts.getBody().size());

    }

}