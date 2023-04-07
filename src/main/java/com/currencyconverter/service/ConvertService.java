package com.currencyconverter.service;

import com.currencyconverter.entity.Valute;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ConvertService {

    public String convert(Valute fromValute,Valute toValute){

        BigDecimal fromdecim = new BigDecimal(fromValute.getValue().replace(",","."));
        BigDecimal todecim = new BigDecimal(toValute.getValue().replace(",","."));

        fromdecim = fromdecim.divide(new BigDecimal(fromValute.getNominal()), RoundingMode.UP);
        todecim = todecim.divide(new BigDecimal(toValute.getNominal()), RoundingMode.UP);

        return  fromdecim.divide(todecim, RoundingMode.UP).toString();
    }


}
