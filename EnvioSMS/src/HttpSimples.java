import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpSimples {  


	public static void main(String[] args) throws Exception{  

		String urlParameters = "user=Joao Mello" +   
				"&password=N1nteress@" +   
				"&destinatario=19994310650" +  
				"&msg=" + URLEncoder.encode("Teste envio de mensagem", "UTF-8");  

				URL url = new URL("http://www.facilitamovel.com/api/simpleSend.ft?");      

				HttpURLConnection connection = (HttpURLConnection) url.openConnection();             
				connection.setDoOutput(true);  
				connection.setDoInput(true);  
				connection.setInstanceFollowRedirects(false);   
				connection.setRequestMethod("POST");   
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");   
				connection.setRequestProperty("charset", "utf-8");  
				connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));  
				connection.setUseCaches (false);  

				OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());  
				wr.write(urlParameters);  
				wr.flush();  

				BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
				StringBuffer strRet = new StringBuffer();  
				String line;  
				while ((line = rd.readLine()) != null) {  
					strRet.append(line);  
				}  
				wr.close();  
				rd.close();  

				System.out.println("Retorno da Chamada HTTP:"+ strRet);  



	}  
	
}