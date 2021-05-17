package com.ama.aws.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bean1")
public class Bean1 {

    @Autowired
    private Bean2 bean2;

    @PostConstruct          
    public void init() {
        bean2.setBean1(this);
    }
}


