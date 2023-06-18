package com.learn.controller;

import com.learn.entity.ProductEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Controller

public class HomeController {

    @RequestMapping("/status")

    public String status(){
        return "status";
    }

}
