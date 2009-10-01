package numguess;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class DispatchServlet extends HttpServlet implements States {

	private final static long serialVersionUID = 20060329; 

	static final String NUMGUESS = "numguess";
    static final String GUESS = "guess";

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
    {
	doGet(req, res);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
    {

	// look up the bean instance in the session
	HttpSession session = req.getSession(true);
	NumberGuessBean numguess = (NumberGuessBean) session.getAttribute(NUMGUESS);

	// create new bean instance if necessary
	if (numguess == null) {
	    numguess = new NumberGuessBean();
	    session.setAttribute(NUMGUESS, numguess);
	}

	// start over if no guess parameter is present
	String guess = req.getParameter(GUESS);
	if (guess == null) {
	    numguess.reset();
	} else {
	    // process the incoming request
	    numguess.setGuess(guess);
	}

	// forward the request to the view corresponding to the current state
	String target = null;
	switch (numguess.getState()) {
	    case WRONG: target = "/wrong.jsp"; break;
	    case RIGHT: target = "/right.jsp"; break;
	    default: target = "/welcome.jsp"; break;
	}
	req.getRequestDispatcher(target).forward(req, res);
    }
}
