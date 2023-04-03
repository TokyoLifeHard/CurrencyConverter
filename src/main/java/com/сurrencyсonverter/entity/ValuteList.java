package com.сurrencyсonverter.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "ValCurs")
public class ValuteList {

    @JacksonXmlProperty(localName = "Date", isAttribute = true)
    String date;

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    String name;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Valute")
    List<Valute> elementList = new ArrayList<>();

    public ValuteList() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Valute> getElementList() {
        return elementList;
    }

    public void setElementList(List<Valute> elementList) {
        this.elementList = elementList;
    }

    @Override
    public String toString() {
        return "ValuteList{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", elementList=" + elementList +
                '}';
    }
}
