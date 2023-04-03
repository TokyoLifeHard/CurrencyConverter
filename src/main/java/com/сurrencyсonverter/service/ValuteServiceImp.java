package com.сurrencyсonverter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.сurrencyсonverter.entity.Valute;
import com.сurrencyсonverter.dto.ValutesDTO;
import com.сurrencyсonverter.entity.ValuteList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ValuteServiceImp implements ValuteService {

    @Autowired
    @Qualifier("valuteAPI")
    RestTemplate restTemplate;
    @Autowired
    ValutesDTO valutesDTO;

    @Value("${api.host}")
    private String url;
    private final String urlWithDate = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002";

    @Override
    public List<Valute> getValutes() {
        valutesDTO.setResponse(getResponse());
        return valutesDTO.getValuteList().getElementList();
    }

    public String getResponse(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        XmlMapper xmlMapper = new XmlMapper();
        ValuteList valuteList = null;
        try {
             valuteList = xmlMapper.readValue(responseEntity.getBody(), ValuteList.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(valuteList.toString());
        return responseEntity.getBody();
    }


}
