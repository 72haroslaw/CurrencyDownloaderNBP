package com.rafalzdzieborski.app;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Iterator;

public class CurrencyHandler extends DefaultHandler {

    private Currency currency;
    private String tagContent;
    private ArrayList<Currency> currencyList = new ArrayList<Currency>();
    private boolean bCurrency = false;
    private boolean bCurrencyCode = false;
    private boolean bBid = false;
    private boolean bAsk = false;

    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        tagContent = null;
        if (qName.equalsIgnoreCase("Rate")) {
            currency = new Currency();
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if (qName.equalsIgnoreCase("Rate")) {
            currencyList.add(currency);
        } else if (qName.equalsIgnoreCase("Currency")) {
            currency.setCurrency(tagContent);
        } else if (qName.equalsIgnoreCase("Code")) {
            currency.setCurrencyCode(tagContent);
        } else if (qName.equalsIgnoreCase("Bid")) {
            currency.setBid(tagContent);
        } else if (qName.equalsIgnoreCase("Ask")) {
            currency.setAsk(tagContent);
        }
    }

    public void characters(char[] buffer, int start, int length) {
        tagContent = new String(buffer, start, length);
    }

    public void readList() {
        Iterator<Currency> it = currencyList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
