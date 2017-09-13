package com.avenuecode.orders.resource;


import com.avenuecode.orders.domain.Order;
import com.avenuecode.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/SearchOrders")
public class OrderSearchResource {

    @Autowired
    OrderService orderService;


    @GetMapping
    public ResponseEntity<List<Order>> listOrders(@RequestParam String status,@RequestParam int noOfProducts) {

        List<Order> orderList = (List<Order>) orderService.listOrders();
        ArrayList<Order> filteredOrders =  new ArrayList<Order>();

        if(status==null || status.length()==0 || noOfProducts<0) return ok(orderList);
        else {
            for (Order currentOrder : orderList) {

                if (currentOrder.getStatus().equals(status)) {
                    if (currentOrder.getDiscount() != null) {
                        if (currentOrder.getProducts() != null && currentOrder.getProducts().size() > noOfProducts) {
                            filteredOrders.add(currentOrder);
                        }
                    }
                }
            }

            return ok(filteredOrders);
        }
    }


}
