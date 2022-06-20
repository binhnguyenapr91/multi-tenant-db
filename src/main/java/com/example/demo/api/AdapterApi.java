package com.example.demo.api;


import com.example.demo.entity.Adapter;
import com.example.demo.mapper.AdapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Binh Nguyen
 * Jun 1, 2022
 */

@RestController
@RequestMapping("/api/v1/adapters")
public class AdapterApi {
    @Autowired
    AdapterMapper processor;

    @GetMapping(value = "", produces = "application/json")
    public List<Adapter> get() {
        return processor.list();
    }
}
