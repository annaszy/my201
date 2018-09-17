

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "assignment2_servlet", urlPatterns = { "/assignment2_servlet" })
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servlet() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//learn which of this would go in doGet and doPost
		String id = request.getParameter("idtoken");
		String url = request.getParameter("imgUrl");
		System.out.println("hey");
		System.out.println(id);
		System.out.println(url);
		 
		 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session=request.getSession();
//		PrintWriter out = response.getWriter();	
//		out.print(session.getAttribute("googleid"));
//		
//		out.println();
//		out.println();
//		out.println(session.getAttribute("accesstoken"));
//		out.println();
//		out.print("get");
		
		
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 String gid = request.getParameter("googleid");
		 
		 
		 
		 
		 String at = request.getParameter("accesstoken");
		 HttpSession session=request.getSession();
		
		 session.setAttribute("googleid",gid); 
		 session.setAttribute("accesstoken", at);
		 
		 PrintWriter out = response.getWriter();	
		 out.print(session.getAttribute("googleid"));
		 out.println("<br>");
		 out.println("<br>");
		 out.print(session.getAttribute("accesstoken"));
		 out.print("post");
	}

}
