package org.hagar.businessapp.controllers;

import org.hagar.businessapp.enums.Colors;
import org.hagar.businessapp.enums.ProductsType;
import org.hagar.businessapp.enums.Size;
import org.hagar.businessapp.model.Order;
import org.hagar.businessapp.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("")
    public ModelAndView getOrders(){
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = ordersService.getAll();
        modelAndView.addObject("orderList",orderList);
        modelAndView.setViewName("orders/orders");
        return modelAndView;
    }

    @GetMapping("/addForm")
    public String addOrderForm(Model model) {
        Order order = new Order();
        model.addAttribute("order",order);
        setEnumAttr(model);
        return "orders/addOrder";
    }

    private  void setEnumAttr(Model model) {
        model.addAttribute("productsType", ProductsType.values());
        model.addAttribute("sizeEnum", Size.values());
        model.addAttribute("colorsEnum", Colors.values());
    }

    @PostMapping("")
    public String addOrder(@ModelAttribute Order order){
        ordersService.createOrder(order);
        return "redirect:/orders";
    }


    @GetMapping ("/delete")
    public String deleteOrder(@RequestParam(name = "orderId") int orderId){
        ordersService.deleteOrder(orderId);
        return "redirect:/orders";
    }
}
