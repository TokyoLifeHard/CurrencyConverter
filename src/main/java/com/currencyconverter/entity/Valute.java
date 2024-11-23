package com.currencyconverter.entity;



import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "Valute")
public class Valute {

    @JacksonXmlProperty(isAttribute = true)
    String ID;
    @JacksonXmlProperty(localName = "NumCode")
    Integer numCode;
    @JacksonXmlProperty(localName = "CharCode")
    String charCode;
    @JacksonXmlProperty(localName = "Nominal")
    Integer nominal;
    @JacksonXmlProperty(localName = "Name")
    String name;
    @JacksonXmlProperty(localName = "Value")
    String value;
    @JacksonXmlProperty(localName = "VunitRate")
    String vunitRate;
    public Valute() {
    }

    public Valute(String ID, Integer numCode, String charCode, Integer nominal, String name, String value, String vunitRate) {
        this.ID = ID;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.vunitRate = vunitRate;
    }

    public Integer getNumCode() {
        return numCode;
    }

    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVunitRate() {
        return vunitRate;
    }

    public void setVunitRate(String vunitRate) {
        this.vunitRate = vunitRate;
    }

    @Override
    public String toString() {
        return "Valute{" +
                "ID='" + ID + '\'' +
                ", numCode=" + numCode +
                ", charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
