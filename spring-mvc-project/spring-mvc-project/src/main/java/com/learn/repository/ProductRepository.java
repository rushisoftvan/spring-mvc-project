package com.learn.repository;

import com.learn.entity.CategoryEntity;
import com.learn.entity.ProductEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public ProductEntity save(ProductEntity entity){
        this.em.persist(entity);
        return entity;
    }

    public List<ProductEntity> findAll(){
        String jpql = "SELECT c FROM ProductEntity c JOIN FETCH c.category WHERE c.activeStatus = 'ACTIVE'";
        TypedQuery<ProductEntity> query = this.em.createQuery(jpql, ProductEntity.class);
        List<ProductEntity> products = query.getResultList();
        return products;
    }

    public ProductEntity findById(Integer id){
        String jqpl = "SELECT c FROM ProductEntity c JOIN FETCH c.category WHERE c.id = :id";
        TypedQuery<ProductEntity> query = this.em.createQuery(jqpl, ProductEntity.class);
        query.setParameter("id" , id);
        ProductEntity productEntity = query.getSingleResult();
        return productEntity;

    }

    public ProductEntity getById(Integer id){
       return  this.em.find(ProductEntity.class , id);

    }

    @Transactional
    public ProductEntity update(ProductEntity entity){
        this.em.merge(entity);
        return entity;
    }


}
