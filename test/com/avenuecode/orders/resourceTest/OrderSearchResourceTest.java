package com.avenuecode.orders.resourceTest;

import com.avenuecode.orders.domain.Order;
import com.avenuecode.orders.resource.OrderSearchResource;
import com.avenuecode.orders.service.OrderService;
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
public class OrderSearchResourceTest {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderSearchResource orderSearchResource;
    @Test
    public void listOrders() throws Exception {
        ResponseEntity<List<Order>> actualOrders;
        actualOrders = orderSearchResource.listOrders("",2);
        assertEquals(orderService.listOrders().size(),actualOrders.getBody().size());
        actualOrders = orderSearchResource.listOrders(null,2);
        assertEquals(orderService.listOrders().size(),actualOrders.getBody().size());
        actualOrders = orderSearchResource.listOrders("SHIPPED",-1);
        assertEquals(orderService.listOrders().size(),actualOrders.getBody().size());
        actualOrders = orderSearchResource.listOrders("ABC",2);
        assertEquals(0,actualOrders.getBody().size());
        actualOrders =  orderSearchResource.listOrders("SHIPPED",2);
        assertEquals(1,actualOrders.getBody().size());



    }

}