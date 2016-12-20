package com.demo.utility;
// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import com.twilio.sdk.resource.list.MessageList;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 







public class TextMe {

		 
	  // Find your Account Sid and Token at twilio.com/user/account.  
	  //TODO: this is soloman's account, please sign up at twilio and use yours
	  public static final String ACCOUNT_SID = "ACb0282b742cff740dcca1080240b450b8";
	  public static final String AUTH_TOKEN = "9a5cf1aa1dc331bd6fa54d50fdebc833";
	 
	  
	  public static void TextIt(String stockName, String stockValue, String cell) throws TwilioRestException {
	    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);	    
	    
	    System.out.println("#############  1");
	    
	    
	    if (cell == null || cell.equals(""))
	    	return;	    		
	    		
	    System.out.println("#############  2");
	    
	    // Build a filter for the MessageList
	    //List<NameValuePair> params = new ArrayList<NameValuePair>();
	    List params = new ArrayList();
	    params.add(new BasicNameValuePair("Body", "stock: " + stockName + " has a value of: " + stockValue));
	    //params.add(new BasicNameValuePair("From", "+1 5075734422"));	507-400-0298    
	    params.add(new BasicNameValuePair("From", "+1 5074000298"));
	    //params.add(new BasicNameValuePair("To", "+1 5073982716"));
	    params.add(new BasicNameValuePair("To", cell));
	    //params.add(new BasicNameValuePair("To", "+1 6144396054"));
	  //  params.add(new BasicNameValuePair("MediaUrl", "http://http://infotechlead.com/wp-content/uploads/2014/01/IBM-Logo.gif"));
	     	     
	    System.out.println("Sending text message");
	    MessageFactory messageFactory = client.getAccount().getMessageFactory();
	    Message message = messageFactory.create(params);
	    System.out.println(message.getSid());
	    System.out.println("Text message sent");
	  }
	}
	

