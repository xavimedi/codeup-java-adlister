import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "AlbumLookyLooServlet", urlPatterns = "/album")
public class AlbumLookyLooServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Album alb = new Album(666, "Machine Girl", "Fire From Above", 2017, 200, "Experimental");
		req.setAttribute("album", alb);
		req.getRequestDispatcher("/album.jsp").forward(req, resp);
	}
}
