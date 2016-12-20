<%@page import="com.demo.utility.TwitterInsighs"%>
<%@page import="com.demo.utility.TextMe"%>
<%@page import="com.demo.utility.YahooFinanceAPI"%>

<%
 //200 + (float)(Math.random() * 100);
 String stockName =  request.getParameter("stock");
 String socialActivity = request.getParameter("enabled");
 
 String stockValue =  YahooFinanceAPI.getPrice(stockName);
 String cell =  request.getParameter("cell");
 %>
<body bgcolor="#e5ffe5">
<h1 align=center> <font color=red>  Greetings Cool People </font></h1> <hr>
<br><br>
<B>Stock Name         : </B> <font color=red> <%= YahooFinanceAPI.getStockName(stockName)%> </font><br>
<B>Stock Value        : </B> <font color=blue>$<%= stockValue%></font><br>
<B>Stock value change : <font color=brown> <%= YahooFinanceAPI.getQuoteChange(stockName)%> </font> </B> <br>
<B>Stock Exchange name: <font color=brown> <%= YahooFinanceAPI.getStockExchange(stockName)%> </font> </B> <br>
<B>Stock EPS      :</B> <font color=brown> <%=YahooFinanceAPI.getEPS(stockName) %></font>

<br>
<%
  if(socialActivity != null && socialActivity.equalsIgnoreCase("true")){ %>
  <B> Social Media Activity (Twitter count) of</B>:  <font color=red> <%= stockName%> </font> 
  <B>Is:</B> <font color=green size="5">
     <%=TwitterInsighs.getTweetCount(TwitterInsighs.getTwitterResultsAsJSONObject(stockName))%>  times </font>         
   <% } else    %>
   <br> <font color=orange size="10"> Social Media Activity Disabled - No data collected. </font>
     
  
<%
  if(cell != null && cell.length() != 0){
     TextMe.TextIt(stockName, stockValue, cell);        
   }
    %>  


<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<hr>
<p> Powered by IBM WebSphere liberty Server <img src="liberty.jpg" alt="liberty" > </p>
