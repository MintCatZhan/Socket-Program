import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWWW extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C/DTD HTML 4.0 "
				+ "Transitional//EN\"\n";
		out.println(docType + "<HTML>\n"
				+ "<head><title>Hello WWW</title></head>\n" + "<body>\n"
				+ "<h1> Hello WWW</h1>" + "</body></html>");
	}
}