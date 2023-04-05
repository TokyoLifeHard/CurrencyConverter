package com.currencyconverter.controller;

import com.currencyconverter.cache.CacheService;
import com.currencyconverter.entity.Valute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/valute")
public class ValutesController {

    @Autowired
    CacheService cacheService;

    @GetMapping("/{name}")
    public Valute getValute(@PathVariable String name){
        return cacheService.getValute(name);
    }

    @PostMapping(path = "/calc_curse" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String,String>> caclCurse(@RequestBody Map<String,String> params){

        Valute fromValute = cacheService.getValute(params.get("from"));
        Valute toValute = cacheService.getValute(params.get("to"));

        BigDecimal fromdecim = new BigDecimal(fromValute.getValue().replace(",","."));
        BigDecimal todecim = new BigDecimal(toValute.getValue().replace(",","."));

        BigDecimal curse = fromdecim.divide(todecim, RoundingMode.UP);
        Map<String,String> resp = new HashMap<>();
        resp.put("message","for 1 "+fromValute.getCharCode()+" your'll get "+curse.toString()+" "+ toValute.getCharCode());
        return new ResponseEntity<Map<String,String>>(resp, HttpStatus.valueOf(200));


    }
}
