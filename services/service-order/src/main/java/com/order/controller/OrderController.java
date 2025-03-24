package com.order.controller;

import com.order.Order;
import com.order.properties.OrderProperties;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope // 激活配置自动刷新功能
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderProperties orderProperties;

//    // 获取Nacos中的配置
//    @Value("${order.timeout}")
//    String orderTimeout;
//    @Value("${order.auto-confirm}")
//    String orderAutoConfirm;


    @GetMapping("/getConfig")
    public String getConfig() {
        return "orderTimeout: " + orderProperties.getTimeout() +
                ", orderAutoConfirm: " + orderProperties.getAutoConfirm() +
                ", dbUrl: " + orderProperties.getDbUrl();
    }

    /**
     * 创建订单
     */
    @RequestMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId) {
        return orderService.createOrder(productId, userId);
    }

    /**
     * 创建订单-秒杀
     */
    @RequestMapping("/create/kill")
    public Order createKillOrder(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId) {
        return orderService.createOrder(productId, userId);
    }

    /**
     * 写数据
     */
    @GetMapping("/write")
    public String writeData() {
        return "write data success";
    }
    /**
     * 读数据
     */
    @GetMapping("/read")
    public String readData() {
        return "read data success";
    }

}
