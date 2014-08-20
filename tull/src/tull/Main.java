package tull;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 

 
public class Main {
 
	private final String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
 
		Main http = new Main();
 
//		System.out.println("Testing 1 - Send Http GET request");
//		for (int i = 0; i < 40; i++) {
//			http.sendGet();
//		}
	
 
		String cake = generateString();
		//System.out.println(cake);
		System.out.println("\nTesting 2 - Send Http POST request");
		for (int i = 0; i < 40; i++) {
		http.sendPost(cake);
		}
		
 
	}
 
	private static String generateString() {
		String id = "raid_id=221436";
		
		String total = id;
		
		total = total + player( 974175 , -3, "");
		total = total + player( 632449 , -3, "");
		total = total + player( 849959 , -3, "");
		total = total + player( 937752 , -3, "");
		total = total + player( 102148 , -3, "");
		total = total + player( 998654 , -3, "");
		total = total + player( 994911 , -3, "");
		total = total + player( 486108 , -3, "");
		total = total + player( 934944 , -3, "");
		total = total + player( 917248 , -3, "");
		total = total + player( 931369 , -3, "");
		total = total + player( 979825 , -3, "");
		total = total + player( 103290 , -3, "");
		total = total + player( 891769 , -3, "");
		total = total + player( 973368 , -3, "");
		total = total + player( 103277 , -3, "");
		total = total + player( 380320 , -3, "");
		total = total + player( 102663 , -3, "");
		total = total + player( 966629 , -3, "");
		total = total + player( 975396 , -3, "");
		total = total + player( 993426 , -3, "");
		total = total + player( 598254 , -3, "");
		total = total + player( 101444 , -3, "");
		total = total + player( 586555 , -3, "");
		total = total + player( 554163 , -3, "");
		total = total + player( 862502 , -3, "");
		total = total + player( 103347 , -3, "");
		total = total + player( 977420 , -3, "");
		total = total + player( 918924 , -3, "");
		total = total + player( 934239 , -3, "");
		
		return total;
	}

	private static String player(int id, int rating, String string) {
		//String product = "&char%5B"+id+"%5D="+rating+"&text%5B"+id+"%5D"+string;
		return "&char%5B"+id+"%5D="+rating+"&text%5B"+id+"%5D="+string;
	}

	// HTTP GET request
	private void sendGet() throws Exception {
 
		String url = "http://openraid.eu/index.php/ajax/votefeedback/11343825/-1";
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
 
	// HTTP POST request
	private void sendPost(String param) throws Exception {
 
		String url = "http://openraid.eu/users/ratebulk";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = param;
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
 
}