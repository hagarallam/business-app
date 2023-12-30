package org.hagar.businessapp.service;

import org.hagar.businessapp.model.Product;
import org.hagar.businessapp.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProductsService {

    private Logger logger = Logger.getLogger(ProductsService.class.getName());
    private ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public boolean addProduct(Product product){
        try{
            productsRepository.save(product);
            return true;
        }
        catch (Exception ex){
            logger.info("Exception while saving because of "+ ex.getMessage());
        }
        return false;
    }

    public List<Product> getAll() {
        try{
            return productsRepository.findAll();
        }
        catch (Exception ex){
            logger.info("Exception while fetching because of "+ ex.getMessage());

        }
        return new ArrayList<>();
    }

    public Product findById(int productId) {
        Product product = null;
        try{
            Optional<Product> optionalProduct = productsRepository.findById(productId);
            if(optionalProduct.isPresent()){
                product=optionalProduct.get();
            }
        }
        catch (Exception ex){
            logger.info("Exception while fetching specific Product with id "+productId+" because of "+ ex.getMessage());

        }
        return product;
    }

    public boolean deleteProduct(int productId) {
        try{
            productsRepository.deleteById(productId);
            return true;
        }
        catch (Exception ex){
            logger.info("Exception while Deleting Product with id "+productId+" because of "+ ex.getMessage());
        }
        return false;
    }
}
