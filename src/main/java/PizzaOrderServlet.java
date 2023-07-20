import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/pizza-order.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String crustType = request.getParameter("crust");
		String sauceType = request.getParameter("sauce");
		String sizeType = request.getParameter("size");
		String[] toppings = request.getParameterValues("toppings");
		String deliveryAddress = request.getParameter("address");

		System.out.println("Crust: " + crustType);
		System.out.println("Sauce: " + sauceType);
		System.out.println("Size: " + sizeType);
		System.out.println("Toppings: " + Arrays.toString(toppings));
		System.out.println("Address: " + deliveryAddress);
	}
}
