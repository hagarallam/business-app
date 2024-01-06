package org.hagar.businessapp.service;

import org.hagar.businessapp.model.Order;
import org.hagar.businessapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class OrdersService {

    private OrderRepository orderRepository;
    private Logger logger = Logger.getLogger(OrdersService.class.getName());

    public OrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll() {
        try{
            return orderRepository.findAll();
        }
        catch (Exception ex){
            logger.info("Exception while fetching because of "+ ex.getMessage());

        }
        return new ArrayList<>();
    }

    public boolean createOrder(Order order) {
        try{
            orderRepository.save(order);
            return true;
        }
        catch (Exception ex){
            logger.info("Exception while saving because of "+ ex.getMessage());
        }
        return false;
    }

    public boolean deleteOrder(int orderId) {
        try{
            orderRepository.deleteById(orderId);
            return true;
        }
        catch (Exception ex){
            logger.info("Exception while Deleting Product with id "+orderId+" because of "+ ex.getMessage());
        }
        return false;
    }
}
