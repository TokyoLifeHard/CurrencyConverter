package com.currencyconverter.exeptions;

public class SameValuteExeption extends RuntimeException{

    public SameValuteExeption(String message) {
        super(message);
    }
}
