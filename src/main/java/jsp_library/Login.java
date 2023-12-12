package jsp_library;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email= req.getParameter("email");
		String password=req.getParameter("password");
		
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		
		UserCRUD crud=new UserCRUD();
		
		
		try {
			String pass= crud.login(email);
			
			if (password.equals(pass)) {
				BookCRUD bookCRUD=new BookCRUD();
				List<Book> books= bookCRUD.display();
				req.setAttribute("list", books);
				RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);
				
			} else {
				req.setAttribute("message", "Invalid User");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
