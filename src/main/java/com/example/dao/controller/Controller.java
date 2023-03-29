package com.example.dao.controller;

import com.example.dao.repository.RepositoryCustomers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    private final RepositoryCustomers repositoryCustomers;

    public Controller(RepositoryCustomers repositoryCustomers) {
        this.repositoryCustomers = repositoryCustomers;
    }

    @GetMapping("/products/fetch-product")
    @ResponseBody
    public String getUserName(@RequestParam("name") String name) {
        List<String> list = repositoryCustomers.userName(name);
        System.out.println(Arrays.toString(list.toArray()));
        return Arrays.toString(list.toArray());
    }
}
