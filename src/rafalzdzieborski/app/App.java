package rafalzdzieborski.app;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class App {
	public static void main(String[] args) throws IOException {

		// URL xml
		URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/eur/?format=xml");

		System.out.println("Currency rate from www.nbp.pl \n");

		// XML Parser
		try {
			InputStream is = url.openStream();

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			CurrencyHandler userhandler = new CurrencyHandler();
			saxParser.parse(is, userhandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}