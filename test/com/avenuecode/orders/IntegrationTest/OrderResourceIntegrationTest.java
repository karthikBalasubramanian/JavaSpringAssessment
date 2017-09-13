package com.avenuecode.orders.IntegrationTest;


import com.avenuecode.orders.OrdersApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;



import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OrdersApplication.class})
@WebAppConfiguration
public class OrderResourceIntegrationTest {

    @Autowired
    private WebApplicationContext wac;



   private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testConnection() {
        ServletContext servletContext = wac.getServletContext();
        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("orderResource"));

    }

    @Test
    public void listOrders() throws Exception {

        this.mockMvc.perform(get("/orders")).andDo(print()).andExpect(status().isOk()).andReturn();
    }


    @Test
    public void getOrder() throws Exception {

        //this.mockMvc.perform(get("/orders/{orderId}", "1")).andDo(print()).andExpect(status().isOk()).andReturn();


    }

}