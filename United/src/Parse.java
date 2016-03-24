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
	        String url = "http://104.131.212.78:8080/ParserService/UA?startDate=03/29/2016&endDate=03/30/2016&origin=DME&destination=KBP&seats=1&class=a:2:{i:0;s:1:%22B%22;i:1;s:1:%22F%22;}&request_id=6492&user_id=200&type=ow";
	        
	        JSONObject flightList = null;
	        ArrayList array = null;
	        /*
	         * {"title":"Free Music Archive - Genres","message":"","errors":[],"total" : "161","total_pages":81,"page":1,"limit":"2",
	         * "dataset":
	         * [{"genre_id": "1","genre_parent_id":"38","genre_title":"Avant-Garde" ,"genre_handle": "Avant-Garde","genre_color":"#006666"},
	         * {"genre_id":"2","genre_parent_id" :null,"genre_title":"International","genre_handle":"International","genre_color":"#CC3300"}]}
	         */
	        try {
	            String genreJson = IOUtils.toString(new URL(url));
	            JSONObject genreJsonObject = (JSONObject) JSONValue.parseWithException(genreJson);
	            // get the title
	            System.out.println("11"+genreJsonObject.get("award_list"));
	            
	            
	            //System.out.println("Тест"+genreJsonObject.get("class_list"));
	            // get the data
	           // JSONArray genreArray = (JSONArray) genreJsonObject.get("dataset");
	            // get the first genre
	           // JSONObject firstGenre = (JSONObject) genreArray.get(0);
	           // System.out.println(firstGenre.get("genre_title"));
	            
	            
	            JSONArray lang = (JSONArray) genreJsonObject.get("award_list");
	           System.out.println("111"+lang);
	           JSONObject flightlist = (JSONObject) lang.get(0);
	            System.out.println(flightlist.get("flight_list"));
	            JSONArray map = (JSONArray)flightlist.get("flight_list");
	            
	            
	            //Вывод массива layover_time
	            for (int i = 0; i < map.size(); i++){
	            
	            JSONObject flightlist1 = (JSONObject) map.get(i);
	            System.out.println("Test"+map.get(i));
	            
	            //layover_time
	            String layoverTime = (String)flightlist1.get("layover_time");
	            System.out.println("layoverTime:"+layoverTime);
	            //depart_time
	            String departTime = (String)flightlist1.get("depart_time");
	            System.out.println("depart_time:"+departTime);
	            //airlineCompany
	            String airlineCompany = (String)flightlist1.get("airline_company");
	            System.out.println("airlineCompany:"+airlineCompany);
	            //arrive_date
	            String arriveDate = (String)flightlist1.get("arrive_date");
	            System.out.println("arriveDate:"+arriveDate);
	            //arrive_code
	            String arriveCode = (String)flightlist1.get("arrive_code");
	            System.out.println("arriveCode:"+arriveCode);
	            //flight_number
	            String flightNumber = (String)flightlist1.get("flight_number");
	            System.out.println("flightNumber:"+flightNumber);
	            //aircraft
	            String aircraft = (String)flightlist1.get("aircraft");
	            System.out.println("aircraft:"+aircraft);
	            //depart_code
	            String departCode = (String)flightlist1.get("depart_code");
	            System.out.println("departCode:"+departCode);
	            //depart_date
	            String departDate = (String)flightlist1.get("depart_date");
	            System.out.println("departDate:"+departDate);
	            //travel_time
	            String travelTime = (String)flightlist1.get("travel_time");
	            System.out.println("travelTime:"+travelTime);
	            //arrive_time
	            String arriveTime = (String)flightlist1.get("arrive_time");
	            System.out.println("arriveTime:"+arriveTime);
	            //meal
	            String meal = (String)flightlist1.get("meal");
	            System.out.println("meal:"+meal);
	            //arrive_place
	            String arrivePlace = (String)flightlist1.get("arrive_place");
	            System.out.println("arrivePlace:"+arrivePlace);
	            //id
	            Long id = (Long)flightlist1.get("id");
	            System.out.println("id:"+id);
	            //depart_place
	            String departPlace = (String)flightlist1.get("depart_place");
	            System.out.println("departPlace:"+departPlace);
	            
	       }  
	           
	            
	            //for (int i = 0; i < lang.size(); i++){
	            //flightList = (JSONObject) lang.get(i);
	            //System.out.println("22"+flightList);
	            
	           /* flightList.get("depart_time");
	            System.out.println("22"+flightList.get("depart_time"));*/
	            
	           /* JSONArray genreArray = (JSONArray) genreJsonObject.get("dataset");
	            // get the first genre
	            JSONObject firstGenre = (JSONObject) genreArray.get(0);
	            System.out.println(firstGenre.get("genre_title"));  */
	            
	              /* for (int j = 0; j < flightList.size(); j++){
              	       flightList.get(j);
              	       System.out.println("33"+flightList.get(j));
                   }*/
	            
	            
	            /*array = new ArrayList(); 
	            array.add(flightList);  */ 
	            //} 
	            
	           /* for (int i = 0; i < array.size(); i++){
	            JSONObject	flightList2 = (JSONObject) array.get(i);
	            
	                  for (int j = 0; j < flightList2.size(); j++){
	                	  flightList2.get(j);
	                	  System.out.println("33"+flightList2.get(j));
	                  }
	            
	            }*/
	            
	            
	        } catch (IOException | ParseException e) {
	            e.printStackTrace();
	        }
	    }    		   


}

