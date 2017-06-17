package rafalzdzieborski.app;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CurrencyHandler extends DefaultHandler{


		boolean currency = false;
		boolean currencyCode = false;
		boolean tableNo = false;
		boolean effectiveDate = false;
		boolean bid = false;
		boolean ask = false;

		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if (qName.equalsIgnoreCase("Currency")) {
				currency = true;
			} else if (qName.equalsIgnoreCase("Code")) {
				currencyCode = true;
			} else if (qName.equalsIgnoreCase("No")) {
				tableNo = true;
			} else if (qName.equalsIgnoreCase("EffectiveDate")) {
				effectiveDate = true;
			} else if (qName.equalsIgnoreCase("Bid")) {
				bid = true;
			} else if (qName.equalsIgnoreCase("Ask")) {
				ask = true;
			}
		}

		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equalsIgnoreCase("ExchangeRatesSeries")) {
				System.out.println("");
			}
		}

		public void characters(char ch[], int start, int length) throws SAXException {
			if (currency) {
				System.out.println("Currency: " + new String(ch, start, length));
				currency = false;
			} else if (currencyCode) {
				System.out.println("Currency code: " + new String(ch, start, length));
				currencyCode = false;
			} else if (tableNo) {
				System.out.println("Table no: " + new String(ch, start, length));
				tableNo = false;
			} else if (effectiveDate) {
				System.out.println("Effective Date: " + new String(ch, start, length) + "\n");
				effectiveDate = false;
			} else if (bid) {
				System.out.println("Bid: " + new String(ch, start, length) + " PLN");
				bid = false;
			}
			else if (ask) {
				System.out.println("Ask: " + new String(ch, start, length) + " PLN\n");
				ask = false;
			}
		}
	
}
