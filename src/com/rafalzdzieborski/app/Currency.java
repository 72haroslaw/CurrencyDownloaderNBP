package com.rafalzdzieborski.app;

public class Currency {

    private String currency;
    private String currencyCode;
    private String tableNo;
    private String effectiveDate;
    private String bid;
    private String ask;
    private String tagName;

    public Currency(){

    }

    public Currency(String currency, String currencyCode, String tableNo, String effectiveDate, String bid, String ask, String tagName) {
        this.currency = currency;
        this.currencyCode = currencyCode;
        this.bid = bid;
        this.ask = ask;
        this.tagName = tagName;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getBid() {
        return bid;
    }

    public String getAsk() {
        return ask;
    }

    public String getTagName() {
        return tagName;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String toString() {
        return  "\nCurrency: " + currency +
                "\nCurrency Code: " + currencyCode +
                "\nBid: " + bid + " PLN" +
                "\nAsk: " + ask + " PLN";
    }
}
