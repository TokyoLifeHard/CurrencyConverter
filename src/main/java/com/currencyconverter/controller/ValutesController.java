package com.currencyconverter.controller;

import com.currencyconverter.cache.CacheService;
import com.currencyconverter.entity.Valute;
import com.currencyconverter.exeptions.NoSuchValuteExeption;
import com.currencyconverter.exeptions.SameValuteExeption;
import com.currencyconverter.service.ConvertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/valute")
public class ValutesController {
    @Autowired
    CacheService cacheService;
    @Autowired
    ConvertService convertService;

    @GetMapping("/{name}")
    @ResponseBody
    public Valute getValute(@PathVariable String name){
        return cacheService.getValute(name);
    }

    @PostMapping(path = "/curse" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String,String>> curse(@RequestBody Map<String,String> params) throws InterruptedException {

        Valute fromValute = cacheService.getValute(params.get("from"));
        Valute toValute = cacheService.getValute(params.get("to"));

        if (fromValute == null || toValute == null){
            throw  new NoSuchValuteExeption("No such valute");
        }

        if(fromValute.equals(toValute)){
            throw new SameValuteExeption("You enter same valutes");
        }

        String curse = convertService.calcCurse(fromValute,toValute);

        Map<String,String> resp = new HashMap<>();
        resp.put("message","for 1 "+fromValute.getCharCode()+" your'll get "+curse+" "+ toValute.getCharCode());
        return new ResponseEntity<Map<String,String>>(resp, HttpStatus.valueOf(200));

    }

    @PostMapping(path = "/convert" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String,String>> convert(@RequestBody Map<String,String> params){

        Valute fromValute = cacheService.getValute(params.get("from"));
        Valute toValute = cacheService.getValute(params.get("to"));
        String fromAmount = params.get("from_amount");

        String convertResult = convertService.convertFromAmount(fromValute,toValute,fromAmount);

        Map<String,String> resp = new HashMap<>();
        resp.put("message","for "+ fromAmount+" "+fromValute.getCharCode()+" your'll get "+convertResult+" "+ toValute.getCharCode());
        return new ResponseEntity<Map<String,String>>(resp, HttpStatus.valueOf(200));
    }

    @ExceptionHandler(NoSuchValuteExeption.class)
    public ResponseEntity<Map<String,String>> handleNoSuchValuteExeption(NoSuchValuteExeption e){
        Map<String,String> map = new HashMap<>(1);
        map.put("message",e.getMessage());
        return new ResponseEntity<Map<String,String>>(map,HttpStatus.valueOf(200));
    }

    @ExceptionHandler(SameValuteExeption.class)
    public ResponseEntity<Map<String,String>> handleSameValuteExeption(SameValuteExeption e){
        Map<String,String> map = new HashMap<>(1);
        map.put("message",e.getMessage());
        return new ResponseEntity<Map<String,String>>(map,HttpStatus.valueOf(200));
    }
}
