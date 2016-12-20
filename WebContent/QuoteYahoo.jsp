<%@page import="com.demo.utility.TextMe"%>
<%@page import="com.demo.utility.YahooFinanceAPI"%>


<%
 //200 + (float)(Math.random() * 100);
 String stockName =  request.getParameter("stock");
 String stockValue =  YahooFinanceAPI.getPrice(stockName);
 String cell =  request.getParameter("cell");
 %>
<body bgcolor="#e5ffe5">
<h1 align=center> <font color=red>  Greetings people </font></h1> <hr>
<br><br>
<B>Stock Name         : </B> <font color=red> <%= YahooFinanceAPI.getStockName(stockName)%> </font><br>
<B>Stock Value        : </B> <font color=blue>$<%= stockValue%></font><br>
<B>Stock value change : <font color=brown> <%= YahooFinanceAPI.getQuoteChange(stockName)%> </font> </B> <br>
<B>Stock Exchange name: <font color=brown> <%= YahooFinanceAPI.getStockExchange(stockName)%> </font> </B> <br>
<B>Stock EPS      :</B> <font color=brown> <%=YahooFinanceAPI.getEPS(stockName) %></font>

<br>

  <%if(cell != null && cell.length() != 0){
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
<p> Powered by liberty profile on IBM Bluemix (www.bluemix.net) <img src="liberty.jpg" alt="liberty" > </p>
