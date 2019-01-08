import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		System.out.println("Constractor");
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		
		//服务端页面跳转,在服务端访问文件,并把文件内容发给浏览器
		/*if (name.equals("admin") && password.equals("123")) {
			System.out.println("Pass");
			request.getRequestDispatcher("success.html").forward(request, response);
		} else {
			System.out.println("Fail");
			request.getRequestDispatcher("fail.html").forward(request, response);
		}*/
		//客户端跳转
		if (name.equals("admin") && password.equals("123")) {
			System.out.println("Pass");
			response.sendRedirect("success.html");
		} else {
			System.out.println("Fail");
			response.sendRedirect("fail.html");
		}
		
		//传回html
		/*String html = null;
		if (name.equals("admin") && password.equals("123")) {
			System.out.println("Pass");
			html = "<div style='color:green'>成功</div>";
		} else {
			System.out.println("Fail");
			html = "<div style='color:red'>失败</div>";
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(html);*/
	}
}
