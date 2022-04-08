package com.kan.aop.proxy.business.entities;

public class CustomerService {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void printName() {
        System.out.println("Customer name:" + this.name);
    }

    public void printUrl() {
        System.out.println("Customer url:" + this.url);
    }

    public void printThrowException() {
        throw new IllegalArgumentException();
    }
}
