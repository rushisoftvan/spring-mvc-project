package com.learn.controller;

import com.learn.dao.ProductDao;
import com.learn.entity.ProductEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Controller

public class HomeController {

    @PersistenceContext
    private EntityManager em;



    private Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/status")
    @Transactional
    public String status(){

        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("T-shirt");
        em.persist(productEntity);
        log.info("<<<<<<<< start() Changed");
        log.info("start() >>>>>>");
        return "status";
    }

}
