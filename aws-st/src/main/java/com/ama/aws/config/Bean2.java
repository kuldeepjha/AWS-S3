package com.ama.aws.config;

import org.springframework.stereotype.Component;

@Component("bean2")
public class Bean2 {

    private Bean1 bean1;   

    public void setBean1(Bean1 bean1) {
        this.bean1 = bean1;
    }
}