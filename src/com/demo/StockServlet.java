package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class FailingServlet
 */
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int ARRAY_SIZE=102400;
	
	 HttpSession session;
	 String kind;
	    
	
    public StockServlet() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		StockQuote quoteService = StockQuote.getInstance();
//		String quote = quoteService.getQuote("IBM");
//		
//		response.sendRedirect("/SimpleWar/quote.jsp?stock=" + quote);
//	}
//	
	
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
throws IOException, ServletException
{
response.setContentType("text/html");

// session is retrieved before getting the writer
session = request.getSession(true); 
//StockQuote quoteService = StockQuote.getInstance();
//String quote = quoteService.getQuote("IBM");

System.out.println("6666666666666666666");


// response.sendRedirect("/SimpleWar/quote.jsp?stock=" + quote);

// see what has been ordered already


PrintWriter out = response.getWriter();

out.println("<html>");
out.println("<body bgcolor=\"#e5ffe5\">");
out.println("<head>");

out.println("<title> Get Quote Liberty app </title>");
out.println("</head>");
out.println("<body>");

out.println("<h1> <font  color=red>WebSphere Application Server Liberty Profile on bluemix</font> </h1>");
out.println("<P>");
out.println("<hr>");

//out.print("<form action=\"quote.jsp\">");
out.print("<form action=\"QuoteYahoo.jsp\">");
out.print("Stock: <input type=\"text\" name=\"stock\" value=\"\"><br>");
out.print("Cell :  <input type=\"text\" name=\"cell\" value=\"\"> (optional, must be registered with Twilio) <br>");
out.print("<input type=\"submit\" value=\"Submit\">");
out.print("</form>");
out.println("<P>");
out.println("<img src=\"stock.gif\" alt=\"stock market View\" >");


// =========



//out.println("<embed src=\"CallStatesTreeAction.do?ivrCallId=${requestScope.vo.callId}&agentId=${requestScope.vo.agentId}\" type=\"application/x-mplayer2\" autostart=\"0\" playcount=\"1\" style=\"width: 40%; height: 45\" />");



//===========





out.println("</body>");
out.println("</html>");

out.close();

}
	
	
	
	
	



	
	

	
	
	
	
}