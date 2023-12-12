package jsp_library;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/editBook")
public class EditBook extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String author=req.getParameter("author");
		double price=Double.parseDouble(req.getParameter("price"));
		String genre=req.getParameter("genre");
		
		Book book=new Book();
		
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setPrice(price);
		
		BookCRUD crud=new BookCRUD();
		
		try {
			int count=crud.update(book);
			if (count!=0) {
				List<Book> books= crud.display();
				req.setAttribute("list", books);
				RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
