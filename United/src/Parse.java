import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parse {
	
	   public static void main(String[] args) {
		    
	        String url = "http://104.131.212.78:8080/ParserService/UA?startDate=04/29/2016&endDate=04/30/2016&origin=DME&destination=KBP&seats=1&class=a:2:{i:0;s:1:%22B%22;i:1;s:1:%22F%22;}&request_id=6492&user_id=200&type=ow";
	        
	        //JSONObject flightList = null;
	        //ArrayList array = null;
	        
	        try {
	            String genreJson = IOUtils.toString(new URL(url));
	            JSONObject genreJsonObject = (JSONObject) JSONValue.parseWithException(genreJson);
	            
	            System.out.println("11"+genreJsonObject.get("award_list"));
	            
	            
	            //получение award_list
	            JSONArray lang = (JSONArray) genreJsonObject.get("award_list");
	            System.out.println("111"+lang);
	            
	          /*  JSONObject classList = (JSONObject) lang.get(1);
	            System.out.println("classList"+classList.get("class_list"));
	        */    //JSONArray map = (JSONArray)flightlist.get("flight_list");
	            
	     for (int j = 0; j < lang.size(); j++){   
	    	    
	    	    //получение flight_list
	            JSONObject flightlist = (JSONObject) lang.get(j);
	            //System.out.println("Весь массив"+flightlist.get("flight_list"));
	            JSONArray map = (JSONArray)flightlist.get("flight_list");
	            
	            //получение class_list
	            JSONObject classList = (JSONObject) lang.get(j);
	            JSONArray arrayClassList = (JSONArray)classList.get("class_list");
	            //System.out.println("classList"+classList.get("class_list"));
	            
	            
	            //Вывод массива flight_list
	            for (int i = 0; i < map.size(); i++){
	            
	            JSONObject flightlist1 = (JSONObject) map.get(i);
	            //System.out.println("Test"+map.get(i));
	            
	            
	            
	            
	            
	            
	            //flight_list
	            //layover_time
	            String layoverTime = (String)flightlist1.get("layover_time");
	            //System.out.println("layoverTime:"+layoverTime);
	            //depart_time
	            String departTime = (String)flightlist1.get("depart_time");
	            //System.out.println("depart_time:"+departTime);
	            //airlineCompany
	            String airlineCompany = (String)flightlist1.get("airline_company");
	            //System.out.println("airlineCompany:"+airlineCompany);
	            //arrive_date
	            String arriveDate = (String)flightlist1.get("arrive_date");
	            //System.out.println("arriveDate:"+arriveDate);
	            //arrive_code
	            String arriveCode = (String)flightlist1.get("arrive_code");
	            //System.out.println("arriveCode:"+arriveCode);
	            //flight_number
	            String flightNumber = (String)flightlist1.get("flight_number");
	            //System.out.println("flightNumber:"+flightNumber);
	            //aircraft
	            String aircraft = (String)flightlist1.get("aircraft");
	            //System.out.println("aircraft:"+aircraft);
	            //depart_code
	            String departCode = (String)flightlist1.get("depart_code");
	            //System.out.println("departCode:"+departCode);
	            //depart_date
	            String departDate = (String)flightlist1.get("depart_date");
	            //System.out.println("departDate:"+departDate);
	            //travel_time
	            String travelTime = (String)flightlist1.get("travel_time");
	            //System.out.println("travelTime:"+travelTime);
	            //arrive_time
	            String arriveTime = (String)flightlist1.get("arrive_time");
	            //System.out.println("arriveTime:"+arriveTime);
	            //meal
	            String meal = (String)flightlist1.get("meal");
	            //System.out.println("meal:"+meal);
	            //arrive_place
	            String arrivePlace = (String)flightlist1.get("arrive_place");
	            //System.out.println("arrivePlace:"+arrivePlace);
	            //id
	            Long id = (Long)flightlist1.get("id");
	            //System.out.println("id:"+id);
	            //depart_place
	            String departPlace = (String)flightlist1.get("depart_place");
	            //System.out.println("departPlace:"+departPlace);
	            
	            
	            
	            //flight_list
	            System.out.println("Время остановки(layoverTime): "+layoverTime+" "+"Время вылета(departTime): "+departTime+" "+"Авиакомпания(airlineCompany): "+airlineCompany+" "+"Время прибытия(arriveDate): "+arriveDate+" "+
	            		"Код места прибытия(arriveCode): "+arriveCode+" "+"Рейсовый номер(flightNumber): "+flightNumber+" "+"Самолет(aircraft): "+aircraft+" "+"Код места вылета(departCode): "+departCode+" "+
	            		"Дата вылета(departDate): "+departDate+" "+"Время полета(travelTime): "+travelTime+" "+"Время прибытия(arriveTime): "+arriveTime+" "+"Место прибытия(arrivePlace): "+arrivePlace+" "+
	            		"Место вылета(departPlace): "+departPlace);
	            
	       }
	            for (int i = 0; i < arrayClassList.size(); i++){
	            	JSONObject classList1 = (JSONObject) arrayClassList.get(i);
		            
		            //class_list name
		            String name = (String)classList1.get("name");
		            //class_list tax
		            String tax = (String)classList1.get("tax");
		            //class_list id
		            Long idClassList = (Long)classList1.get("id");
		            //class_list status
		            String status = (String)classList1.get("status");
		            //class_list mileage
		            String mileage = (String)classList1.get("mileage");
		            
		            //class_list
		            System.out.println("name :"+name+" "+"tax: "+tax+" "+"idClassList: "+idClassList+" "+"status: "+status+" "+"mileage: "+mileage);
	            }
	            
	            
	  }       
	        } catch (IOException | ParseException e) {
	            e.printStackTrace();
	        }
	    }    		   


}

