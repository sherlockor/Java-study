import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		System.out.println("Constractor");
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		
		String html = null;
		if (name.equals("admin") && password.equals("123")) {
			System.out.println("Pass");
			html = "<div style='color:green'>³É¹¦</div>";
		} else {
			System.out.println("Fail");
			html = "<div style='color:red'>Ê§°Ü</div>";
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(html);
	}
}
