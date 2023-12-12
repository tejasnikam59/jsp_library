package jsp_library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "root");
	}
	
	public List<Book> display() throws Exception {
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement= connection.prepareStatement("select * from book");
		
		ResultSet resultSet= preparedStatement.executeQuery();
		
		List<Book> list=new ArrayList();
		while (resultSet.next()) {
			Book book=new Book();
			book.setId(resultSet.getInt("id"));
			book.setName(resultSet.getString("name"));
			book.setAuthor(resultSet.getString("authorname"));
			book.setGenre(resultSet.getString("genre"));
			book.setPrice(resultSet.getDouble("price"));
			list.add(book);
		}
		
		connection.close();
		return list;
	}

	public int delete(int id) throws Exception {
		
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from book where id=?");
		preparedStatement.setInt(1, id);
		
		int res= preparedStatement.executeUpdate();
		connection.close();
		return res;
	}
	
	public int saveBook(Book book) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into book values(?,?,?,?,?)");
		preparedStatement.setInt(1, book.getId());
		preparedStatement.setString(2, book.getName());
		preparedStatement.setString(3, book.getAuthor());
		preparedStatement.setDouble(4, book.getPrice());
		preparedStatement.setString(5, book.getGenre());
		
		int res=preparedStatement.executeUpdate();
		connection.close();
		return res;
	}

	public Book find(int id) throws Exception {
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("select * from book where id=?");
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		Book book=new Book();
		
		while (resultSet.next()) {
			book.setId(resultSet.getInt("id"));
			book.setName(resultSet.getString("name"));
			book.setAuthor(resultSet.getString("authorname"));
			book.setGenre(resultSet.getString("genre"));
			book.setPrice(resultSet.getDouble("price"));
		}
		
		connection.close();
		return book;
		
	}
	
	public int update(Book book) throws Exception {
		Connection connection=getConnection();
		 
		PreparedStatement preparedStatement=connection.prepareStatement("update book set name=?,authorname=?,price=?,genre=? where id=?");
		
		preparedStatement.setString(1, book.getName());
		preparedStatement.setString(2, book.getAuthor());
		preparedStatement.setDouble(3, book.getPrice());
		preparedStatement.setString(4, book.getGenre());
		preparedStatement.setInt(5, book.getId());
		int res =preparedStatement.executeUpdate();
		
		connection.close();
		return res;
	}
}
