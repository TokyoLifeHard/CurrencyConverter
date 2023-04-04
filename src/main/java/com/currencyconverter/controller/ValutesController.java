package com.currencyconverter.controller;

import com.currencyconverter.cache.CacheService;
import com.currencyconverter.entity.Valute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/valutes")
public class ValutesController {

    @Autowired
    CacheService cacheService;

    @GetMapping
    public Valute getValute(){
        return null;
    }

}
