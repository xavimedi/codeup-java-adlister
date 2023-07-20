import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
	private static final int MIN_GUESS = 1;
	private static final int MAX_GUESS = 3;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/guess.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int randomGuess = generateRandomNumber();
		int guess = getGuess(req.getParameter("guess"), resp);

		if (guess == randomGuess) {
			resp.sendRedirect("/correct");
		} else {
			resp.sendRedirect("/incorrect");
		}
	}

	private int generateRandomNumber() {
		Random random = new Random();
		return random.nextInt(MAX_GUESS - MIN_GUESS + 1) + MIN_GUESS;
	}

	private int getGuess(String guessParameter, HttpServletResponse resp) throws IOException {
		try {
			int guess = Integer.parseInt(guessParameter);
			if (guess < MIN_GUESS || guess > MAX_GUESS) {
				resp.sendRedirect("/guess.jsp");
			}
			return guess;
		} catch (NumberFormatException e) {
			resp.sendRedirect("/guess.jsp");
			return 0;
		}
	}
}
