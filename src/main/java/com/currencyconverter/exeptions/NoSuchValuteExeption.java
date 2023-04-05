package com.currencyconverter.exeptions;

public class NoSuchValuteExeption extends RuntimeException{
    public NoSuchValuteExeption(String message) {
        super(message);
    }
}
