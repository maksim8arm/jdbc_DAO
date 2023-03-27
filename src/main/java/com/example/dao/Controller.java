package com.example.dao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    private final Repo repo;

    public Controller(Repo repo) {
        this.repo = repo;
    }

    @GetMapping("/products/fetch-product")
    @ResponseBody
    public String getUserName(@RequestParam("name") String name) {

        List<List<String>> list = repo.userName(name);
        System.out.println(Arrays.toString(list.toArray()));
        return Arrays.toString(list.toArray());

    }

}
