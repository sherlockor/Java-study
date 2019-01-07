import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		
		String html = null;
		if (name.equals("admin") && password.equals("123")) {
			System.out.println("Pass");
			html = "<div style='color:green'>Success</div>";
		} else {
			System.out.println("Fail");
			html = "<div style='color:red'>Fail</div>";
		}
		
		PrintWriter pw = response.getWriter();
		pw.println(html);
	}
}
