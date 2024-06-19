package WeatherDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class Weather
 */
@WebServlet("/Weather")
public class Weather extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Weather() {
        super();
        // TODO Auto-generated constructor stub
    }

	boolean b = false;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cit=request.getParameter("city");
		String city="";
		for(int i=0; i<cit.length(); i++) {
			if(cit.charAt(i)==' ')
				break;
			else
				city+=cit.charAt(i);
		}
		
		try {
			
			String Weather;
			
				Weather = getWeather(city);
			
			JsonObject wdata=ParseWeather(Weather);
			response.setContentType("text/html");
			
			request.setAttribute("l1", "Weather Report in "+city);
			request.setAttribute("l2", "Location "+wdata.get("location"));
			if(b) {
			request.setAttribute("cl", "class");
			request.setAttribute("l3", "Date & Time "+wdata.get("time"));
			request.setAttribute("l4", "Region "+wdata.get("region"));
			request.setAttribute("l5", "Temprature "+wdata.get("temprature")+"<svg  xmlns=\"http://www.w3.org/2000/svg\"  width=\"26\"  height=\"32\"  viewBox=\"0 0 24 24\"  fill=\"none\"  stroke=\"currentColor\"  stroke-width=\"2\"  stroke-linecap=\"round\"  stroke-linejoin=\"round\"  class=\"icon icon-tabler icons-tabler-outline icon-tabler-temperature-plus\"><path stroke=\"none\" d=\"M0 0h24v24H0z\" fill=\"none\"/><path d=\"M8 13.5a4 4 0 1 0 4 0v-8.5a2 2 0 0 0 -4 0v8.5\" /><path d=\"M8 9l4 0\" /><path d=\"M16 9l6 0\" /><path d=\"M19 6l0 6\" /></svg>");
			request.setAttribute("l6", "Climate "+wdata.get("type"));
			}
			
			

			RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
			
			
			
				} catch (Exception e) {
//					e.printStackTrace();
					request.setAttribute("l2",   "Due to Technical Issue. Try after Sometime");
//					b = false;
					RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
					rd.include(request, response);
				}
		
	}
	
	private String getWeather(String city) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q="+city))
				.header("x-rapidapi-key", "910f92ceccmsha1d0aed0fe933aep16ee5ajsn9e3fc944bf62")
				.header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
		return response.body();
	}
	
	private JsonObject ParseWeather(String Weather) {
		
		JsonParser paser = new JsonParser();
		JsonObject json = paser.parse(Weather).getAsJsonObject();
		
		JsonObject wdata = new  JsonObject();
		
		JsonObject ldata = json.getAsJsonObject("location");
		
		JsonObject cdata = json.getAsJsonObject("current");
	
	try {
		
		wdata.addProperty("location", ldata.getAsJsonPrimitive("name").getAsString());
		wdata.addProperty("time", cdata.getAsJsonPrimitive("last_updated").getAsString());
		wdata.addProperty("region", ldata.getAsJsonPrimitive("region").getAsString());
		wdata.addProperty("temprature", cdata.getAsJsonPrimitive("temp_c").getAsDouble());
		wdata.addProperty("type", cdata.getAsJsonObject("condition").getAsJsonPrimitive("text").getAsString());
		b = true;
		
		}catch(NullPointerException e) {
			wdata.addProperty("location",   "Please enter the City name Properly..");
			b = false;
		}

		return wdata;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		pw.println("Working");
	}

}
