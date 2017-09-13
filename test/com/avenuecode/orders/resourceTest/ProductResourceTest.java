package com.avenuecode.orders.resourceTest;

import com.avenuecode.orders.domain.Product;
import com.avenuecode.orders.resource.ProductResource;
import com.avenuecode.orders.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductResourceTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductResource productResource;

    @Test
    public void listProducts() throws Exception {

        List<Product> getAllProducts =  productService.listProducts();
        ResponseEntity<List<Product>> actualOrders;

        actualOrders = (ResponseEntity<List<Product>>) productResource.listProducts();

        assertThat(actualOrders.getBody(),hasSize(5));
        assertEquals(getAllProducts.size(),actualOrders.getBody().size());
        assertNotNull(actualOrders.getBody());

    }

    @Test
    public void getProduct() throws Exception {


        ResponseEntity<Product> theProduct;
        theProduct =  productResource.getProduct("8");
        assertEquals(404,theProduct.getStatusCodeValue());
        theProduct = productResource.getProduct("1");
        assertNotNull(theProduct.getBody());
        assertEquals(theProduct.getBody().getPrice(),productService.getProduct("1").getPrice());
        theProduct = productResource.getProduct("ABC");
        assertEquals(404,theProduct.getStatusCodeValue());
    }

}
