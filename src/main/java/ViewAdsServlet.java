import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebServlet("/ads")
public class ViewAdsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		Ads adsDao  = DaoFactory.getAdsDao();

		List<Ad> ads = adsDao.all();
		req.setAttribute("ads", ads);
		req.getRequestDispatcher("/ads/index.jsp").forward(req, resp);
	}
}