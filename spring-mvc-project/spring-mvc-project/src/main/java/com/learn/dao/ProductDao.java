package com.learn.dao;

import com.learn.entity.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends AbstractDao<Integer , ProductEntity> {

    public void save(ProductEntity productEntity) {
        persist(productEntity);
    }

}
