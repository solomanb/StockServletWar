/*
 * IBM Confidential
 *
 * OCO Source Materials
 *
 * WLP Copyright IBM Corp. 2016
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */
package com.demo.utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.ibm.json.java.JSONObject;


public class TwitterInsighs {

	
	//TODO:  this is Soloman's account, please create one for yourself.  This is TWitterInsight in bluemix.
	
	    private static final String COUNT_URL = "https://cdeservice.mybluemix.net:443/api/v1/messages/count";
	    private static final String COUNT_QUERY_PARAM = "q";
	    private static final String USERNAME = "7d78415d-6777-406d-8168-8efd0e3b48a2";
	    private static final String PASSWORD = "T1QCBKTw8p";
	   
	    
	    public static void main(String[] args) {
	    	//Sample invocation
	    	JSONObject jsonObject = getTwitterResultsAsJSONObject("bluemix");
	    	
	    	//Print out the search.results value
	    	System.out.println("Count: " + getTweetCount(jsonObject));
	    }

	    public static String  getTweetCount(JSONObject jo)
	    {    	
	    	Long L = (Long) ((JSONObject)jo.get("search")).get("results");
	    	return L.toString();
	    }
	    
	    
	    public static JSONObject getTwitterResultsAsJSONObject(String queryString){
	        //Authentication Header
	        String authorizationHeader = "Basic " + Base64Coder.base64Encode(USERNAME + ":" + PASSWORD);

	        //Get our connection obj
	        HttpURLConnection connection = getConnection(COUNT_URL + "?" + COUNT_QUERY_PARAM + "=" +  queryString);

	        try {
	            //Count is "GET".  Change this if you want to do other method
	            connection.setRequestMethod("GET");

	            //Credentials headers
	            connection.setRequestProperty("Authorization", authorizationHeader);

	            //Obtain response
	            final int responseCode = connection.getResponseCode();

	            System.out.println("ResponseCode: " + responseCode);

	            if (responseCode == HttpURLConnection.HTTP_OK) 
	            {
	                return (JSONObject.parse((connection.getInputStream())));	                        
	            
	            } else {
	                return (JSONObject.parse((connection.getErrorStream())));
	            }

	        } catch (IOException e) {
	            System.out.println("IOException: " + e.getMessage());
	        }
	        
	        return null;
	    }

	    private static HttpURLConnection getConnection(String path) {
	        try {
	            System.out.println("Building connection for path: " + path);
	            URL url = new URL(path);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	            //We trust the outgoing connection since that is the configured target server
	            TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
	            
	                public X509Certificate[] getAcceptedIssuers() {
	                    return null;
	                }

	            
	                public void checkClientTrusted(X509Certificate[] certs, String authType) {}

	            
	                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
	            } };

	            SSLContext sc = SSLContext.getInstance("TLS");
	            sc.init(null, trustAllCerts, new SecureRandom());
	            if (connection instanceof HttpsURLConnection) {
	                ((HttpsURLConnection) connection).setSSLSocketFactory(sc.getSocketFactory());
	            }

	            return connection;

	        } catch (IOException e) {
	            System.out.println("IOException: " + e.getMessage());
	        } catch (NoSuchAlgorithmException e) {
	            System.out.println("NoSuchAlgorithmException: " + e.getMessage());
	        } catch (KeyManagementException e) {
	            System.out.println("KeyManagementException: " + e.getMessage());
	        }
	        return null;
	    }

	}
