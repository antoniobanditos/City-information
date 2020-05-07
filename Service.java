import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.json.*;
import com.neovisionaries.i18n.*;

public class Service {

	String country;
	String currency;
	public Service(String country) {
	this.country=country;
	
	//TODO efficiency
	 Map<String, String> countries = new HashMap<String,String>();
	    for (String iso : Locale.getISOCountries()) {
	        Locale l = new Locale("", iso);
	        countries.put(l.getDisplayCountry(), iso);
	    }
	currency= NumberFormat.getCurrencyInstance(new Locale
			("",CountryCode.getByCode(countries.get(country)).toString()))
			.getCurrency().toString();
	}

	/**
	 * @param city
	 * @return string witch describe weather in given city or empty string if some error happen
	 */
	public String getWeather(String city) {
		try {
			JSONObject json = new JSONObject(getTextfromURL("http://api.openweathermap.org/data/2.5/weather?q="+
			city+"&APPID=3328b1dd8da5c19cd6acefa14f29db02"));
	//		System.out.println(readed_text);
			
			String weather_string = "<html>Weather: "+(json.getJSONArray("weather").getJSONObject(0).
					get("main")).toString()+ ",<br>temperature: "+
					json.getJSONObject("main").get("temp").toString();
			
			if(json.getJSONObject("wind").has("deg")) {
				
				weather_string+=(",<br>wind direction:"+json.getJSONObject("wind").get("deg")+" degrees, wind speed "+ 
						json.getJSONObject("wind").get("speed")+"</html>");
				
			}else {
				weather_string+=(", <br>wind speed "+json.getJSONObject("wind").get("speed")+"</html>");
			}
			return weather_string.toString();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * @param currency_of_rate
	 * @return rate of national currency to given currency or 0 if some error happen
	 */
	public BigDecimal getRateTo(String currency_of_rate) {
		try {
			JSONObject json = new JSONObject(getTextfromURL("https://fcsapi.com/api-v2/forex/converter?symbol="+ 
					currency_of_rate+"/"+currency+
					"&amount=1&access_key=gYx2SW6jKLmCPnv2qY6yZLDozjiuzzXaQlZp335qqtTcdrGrQX"));
			return new BigDecimal(json.getJSONObject("response").get("price_1x_"+currency_of_rate).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new BigDecimal(0);
	}
	
	/**
	 * @return rate of national currency to Polish zloty by NBP or 0 if some error happen
	 */
	public BigDecimal getNBPRate() {
		if(currency.toUpperCase().equals("PLN")) {
			return BigDecimal.valueOf(1);
		}
		try {
			JSONObject json = new JSONObject(getTextfromURL("http://api.nbp.pl/api/exchangerates/rates/a/"+
					currency+"/?format=json"));
			return new BigDecimal(json.getJSONArray("rates").getJSONObject(0).get("mid").toString());
		}catch (FileNotFoundException e) {// if given currency not exist in NBP table A then check in NBP table B
			try {
				JSONObject json = new JSONObject(getTextfromURL("http://api.nbp.pl/api/exchangerates/rates/b/"+
				currency+"/?format=json"));
				return new BigDecimal(json.getJSONArray("rates").getJSONObject(0).get("mid").toString());
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return new BigDecimal(0);
	}
	
	/**
	 * @param url_string
	 * @return text extracted from url 
	 * @throws IOException
	 */
	private String getTextfromURL(String url_string) throws IOException  {
		URL url = new URL(url_string);
		
		URLConnection urlCon= url.openConnection();
		BufferedReader reader = new BufferedReader(
		        new InputStreamReader(urlCon.getInputStream()));
		String readed_text="";		
		String inputLine;
		while ((inputLine = reader.readLine()) != null) {
			readed_text+=inputLine;
		}
		reader.close();
		return readed_text;
	}
}  


