import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {

	private int count = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		count++;
		out.println("Page view count is " + count);
	}
}
