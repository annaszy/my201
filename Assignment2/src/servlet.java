

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "assignment2_servlet", urlPatterns = { "/assignment2_servlet" })
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servlet() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	
	
	
	
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
