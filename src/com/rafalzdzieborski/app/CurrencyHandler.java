package com.rafalzdzieborski.app;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CurrencyHandler extends DefaultHandler {

    boolean currency = false;
    boolean currencyCode = false;
    boolean tableNo = false;
    boolean effectiveDate = false;
    boolean bid = false;
    boolean ask = false;

    public void startElement(String uri, String localName, String tagName, Attributes attributes) throws SAXException {
        if (tagName.equalsIgnoreCase("Currency")) {
            currency = true;
        } else if(tagName.equalsIgnoreCase("Code")) {
            currencyCode = true;
        } else if(tagName.equalsIgnoreCase("No")) {
            tableNo = true;
        } else if(tagName.equalsIgnoreCase("EffectiveDate")) {
            effectiveDate = true;
        } else if(tagName.equalsIgnoreCase("Bid")) {
            bid = true;
        } else if(tagName.equalsIgnoreCase("Ask")) {
            ask = true;
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (currency){
            System.out.println("Currency: " + new String(ch, start, length));
            currency = false;
        } else if(currencyCode) {
            System.out.println("Currency code: " + new String(ch, start, length));
            currencyCode = false;
        } else if(tableNo) {
            System.out.println("Table no: " + new String(ch, start, length));
            tableNo = false;
        } else if(effectiveDate) {
            System.out.println("Effective Date: " + new String(ch, start, length) + "\n");
            effectiveDate = false;
        } else if(bid) {
            System.out.println("Bid: " + new String(ch, start, length) + " PLN");
            bid = false;
        } else if(ask) {
            System.out.println("Ask: " + new String(ch, start, length) + " PLN\n");
            ask = false;
        }
    }
}
