package com.currencyconverter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.currencyconverter.entity.ValuteList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ValuteServiceImp implements ValuteService {

    @Autowired
    @Qualifier("valuteAPI")
    RestTemplate restTemplate;

    @Value("${api.host}")
    private String url;




    public ValuteList getValutes(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        XmlMapper xmlMapper = new XmlMapper();
        ValuteList valuteList = null;
        try {
             valuteList = xmlMapper.readValue(responseEntity.getBody(), ValuteList.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return valuteList;
    }


}
