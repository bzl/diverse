import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


public class AttemptThree {

	public static void main(String[] args) {
		   HttpClient httpClient = new DefaultHttpClient();

		    try {
		        HttpPost request = new HttpPost("http://strawpoll.me/ajax/vote");
		        StringEntity params =new StringEntity("data={\"votes\":\"0\",\"id\":\"2128505\"} ");
		        request.addHeader("content-type", "application/x-www-form-urlencoded");
		        request.addHeader("", "");
		        request.addHeader("If-None-Match", "680d1");
		        request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36");
		        //request.addHeader("Content-Length", "24");
		        
		        
		        request.setEntity(params);
		        HttpResponse response = httpClient.execute(request);

		        BufferedReader rd = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));

				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}

				System.out.println(result.toString());
		    }catch (Exception ex) {
		       System.out.println("critical failure");
		       ex.printStackTrace();
		    } finally {
		        httpClient.getConnectionManager().shutdown();
		    }
System.out.println("terminated");
	}

}
