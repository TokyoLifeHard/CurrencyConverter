package com.сurrencyсonverter.controller;

import com.сurrencyсonverter.entity.Valute;
import com.сurrencyсonverter.service.ValuteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/valutes")
public class ValutesController {

    @Autowired
    ValuteServiceImp valuteService;

    @GetMapping(value = "/today", consumes = MediaType.ALL_VALUE)
    public String getValutes(){
        return valuteService.getResponse();
    }
    @GetMapping(value = "/today1")
    public List<Valute> getValutes1(){
        return valuteService.getValutes();
    }
}
