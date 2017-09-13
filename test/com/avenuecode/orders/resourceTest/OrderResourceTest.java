package com.avenuecode.orders.resourceTest;


import com.avenuecode.orders.domain.Order;
import com.avenuecode.orders.resource.OrderResource;
import com.avenuecode.orders.service.OrderService;
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
public class OrderResourceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderResource orderResource;
    @Test
    public void listOrders() throws Exception {
        List<Order> getAllOrders =  orderService.listOrders();
        ResponseEntity<List<Order>> actualOrders;

        actualOrders = (ResponseEntity<List<Order>>) orderResource.listOrders();

        assertThat(actualOrders.getBody(),hasSize(5));
        assertEquals(getAllOrders.size(),actualOrders.getBody().size());
        assertNotNull(actualOrders.getBody());

    }

    @Test
    public void getOrder() throws Exception {
        ResponseEntity<Order> theOrder;
        theOrder =  orderResource.getOrder("8");
        assertEquals(404,theOrder.getStatusCodeValue());
        theOrder = orderResource.getOrder("1");
        assertNotNull(theOrder.getBody());
        assertEquals(theOrder.getBody().getTotal(),orderService.getOrder("1").getTotal());
        theOrder = orderResource.getOrder("ABC");
        assertEquals(404,theOrder.getStatusCodeValue());
    }
}
