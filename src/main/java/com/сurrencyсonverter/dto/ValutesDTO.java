package com.сurrencyсonverter.dto;

import com.сurrencyсonverter.entity.Valute;
import com.сurrencyсonverter.entity.ValuteList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ValutesDTO {
    @Value("test")
    String response;

    public ValutesDTO() {
    }

    public ValutesDTO(String response) {
        this.response = response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ValuteList getValuteList(){
        ValuteList valuteList = new ValuteList();
        valuteList.setElementList(getValutes());
        valuteList.setName(getName());
        valuteList.setDate(getDate());
        return valuteList;
    }

    private ArrayList<Valute> getValutes(){
        String[] valutes = this.response.split("Valute");
        ArrayList<Valute> valuteList = new ArrayList<>(valutes.length-1);
        for (int i = 1;i < valutes.length;i++){
            valuteList.add(getValute(valutes[i]));
        }
        return valuteList;
    }

    private String getName(){
        String subString  = this.response.substring(this.response.lastIndexOf("name=\""));
        return subString.split("\"")[1];
    }

    private String getDate(){
        return this.response.substring(this.response.lastIndexOf("ValCurs Date=\""),
                                this.response.indexOf("ValCurs Date=\"")+10);
    }

    private Valute getValute(String valuteInXML){
        return null;
    }
}
