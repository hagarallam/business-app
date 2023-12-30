package org.hagar.businessapp.repository;

import org.hagar.businessapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product,Integer> {


}
