package com.supermarket.categories;


import com.supermarket.categories.models.Microservice;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class egisterController {

    private final static String DISCOVERY_URL = "http://localhost:8090/register";
    private RestTemplate rest;
    private ArrayList<Microservice> services;

    public RegisterController() {
        rest = new RestTemplate();
        services = new ArrayList<>();
    }

    public void registerServices(String host, String port) {


        Microservice ms = new Microservice();
        ms.setAddress(makeUrl(host, port, "categories"));
        ms.setMkeys("category-management");
        ms.setVersion(1);
        ms.setName("categories");
        services.add(ms);

        ms = new Microservice();
        ms.setAddress(makeUrl(host, port, "categories-by-ids"));
        ms.setMkeys("categories-by-ids");
        ms.setVersion(1);
        ms.setName("categories");
        services.add(ms);

        ms = new Microservice();
        ms.setAddress(makeUrl(host, port, "images"));
        ms.setMkeys("upload-category-image");
        ms.setVersion(1);
        ms.setName("categories");
        services.add(ms);

        for (Microservice service : services) {
            rest.postForLocation(DISCOVERY_URL,service);
        }
    }

    private String makeUrl(String host, String port, String path) {

        return "http://" + host + ":" + port + "/" + path;
    }
}
