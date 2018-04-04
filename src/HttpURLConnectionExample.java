import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.*;
public class HttpURLConnectionExample {
	private static final String GET_URL = "https://http-hunt.thoughtworks-labs.net/challenge/input";

	private static final String POST_URL = "https://http-hunt.thoughtworks-labs.net/challenge/output";
	public static void main(String[] args) throws ParseException {
		try {
			HttpURLConnectionExample.sendGet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void sendGet() throws IOException, JSONException, ParseException {
		 URL obj = new URL(GET_URL);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     con.setRequestProperty("userId", "HynK-sv9f");
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	     //Read JSON response and print
	     System.out.println(response.toString());
	     JSONArray myResponse = new JSONArray(response.toString());
	     int length = myResponse.length();
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 	 Date currentDate = new Date();
	 	 int amount = 0;
	     for(int i=0; i<length; i++){
	    	 Date startDate = dateFormat.parse(myResponse.getJSONObject(i).get("startDate").toString()); 
	    	 if(startDate.before(currentDate) && myResponse.getJSONObject(i).get("endDate").equals(null)){
	    		amount = amount + Integer.parseInt(myResponse.getJSONObject(i).get("price").toString());
	    	 } else if(!myResponse.getJSONObject(i).get("endDate").equals(null)){
	    		 Date endDate = dateFormat.parse(myResponse.getJSONObject(i).get("endDate").toString());
	    		 if(startDate.before(currentDate) && endDate.after(currentDate)){
	    			 amount = amount + Integer.parseInt(myResponse.getJSONObject(i).get("price").toString());
	    		 }
	    	 }
	     }
	     HttpURLConnectionExample.sendPost(amount);
	     
	}
	
	private static void sendPost(int amount) throws IOException, JSONException{
		 URL obj = new URL(POST_URL);
		 JSONObject outputValue = new JSONObject();
		 outputValue.put("totalValue", amount);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("POST");
	     //add request header
	     con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	     con.setRequestProperty("userId", "HynK-sv9f");
	     con.setDoOutput(true);
	     OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
	     wr.write(outputValue.toString());
	     wr.close();
	     con.connect();
	     String output1=con.getResponseMessage();
	     System.out.println(output1);
         con.disconnect();
	}
}
