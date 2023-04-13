package com.currencyconverter.cache;


import com.currencyconverter.entity.Valute;
import com.currencyconverter.entity.ValuteList;
import com.currencyconverter.service.ValuteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@CacheConfig(cacheNames = "valutes")
@Service
public class CacheService {
    @Autowired
    ValuteServiceImp valuteServiceImp;
    @Autowired
    CacheManager cacheManager;
    @PostConstruct
    public void init(){
        addValutesToCache();
    }

    @Cacheable
    public Valute getValute(String name){
        return (Valute) cacheManager.getCache("valutes").get(name);
    }
    @Scheduled(cron = "0 15 1 * * *")
    public void refreshCache(){
        cacheManager.getCache("valutes").clear();
        addValutesToCache();
    }

    public void addValutesToCache(){
        Cache valutes = cacheManager.getCache("valutes");
        ValuteList valuteList = valuteServiceImp.getValutes();
        for (Valute valute : valuteList.getElementList()) {
            valutes.put(valute.getName(),valute);
        }
    }
}
