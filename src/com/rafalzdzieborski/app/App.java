package com.rafalzdzieborski.app;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class App {
	public static void main(String[] args) throws IOException {

		final String urlTableC = "http://api.nbp.pl/api/exchangerates/tables/c/?format=xml";
		URL url = new URL(urlTableC);
		System.out.println("Currency rate from www.nbp.pl");

		try(InputStream is = url.openStream()){
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			CurrencyHandler currencyHandler = new CurrencyHandler();
			saxParser.parse(is, currencyHandler);
			currencyHandler.readList();
		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}
}