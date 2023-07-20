import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "QuoteLookyLooServlet", urlPatterns = "/quote")
public class QuoteLookyLooServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Quote quo = new Quote(4, "Bobby Knuckles", "Get away from me!");
		req.setAttribute("quote", quo);
		req.getRequestDispatcher("/quote.jsp").forward(req, resp);
	}
}