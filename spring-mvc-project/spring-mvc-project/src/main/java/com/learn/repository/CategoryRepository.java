package com.learn.repository;

import com.learn.entity.CategoryEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CategoryRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public CategoryEntity save(CategoryEntity entity){
        this.em.persist(entity);
        return entity;
    }

    public CategoryEntity update(CategoryEntity entity){
        this.em.merge(entity);
        return entity;
    }

    public CategoryEntity findById(Integer id){
        CategoryEntity categoryEntity = this.em.find(CategoryEntity.class, id);
        return categoryEntity;
    }

    public List<CategoryEntity> findAll(){
        String jpql = "SELECT c FROM CategoryEntity c WHERE c.activeStatus = 'ACTIVE'";
        TypedQuery<CategoryEntity> query = this.em.createQuery(jpql, CategoryEntity.class);
        List<CategoryEntity> categories = query.getResultList();
        return categories;
    }

}
