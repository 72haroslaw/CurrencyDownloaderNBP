package rafalzdzieborski.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class App {
	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		//URL xml
		URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/eur/?format=xml");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		//Stream
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			sb.append(inputLine);
		}
		in.close();

		//File writer
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("currency.xml"));
			writer.write(sb.toString());

		} catch (IOException e) {
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
		
		
		System.out.println("Currency rate from www.nbp.pl \n");
		
		//XML Parser
		try {
			File inputFile = new File("currency.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			CurrencyHandler userhandler = new CurrencyHandler();
			saxParser.parse(inputFile, userhandler);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}