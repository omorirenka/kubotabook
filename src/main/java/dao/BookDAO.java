package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Book;

public class BookDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static List<Book> searchBookByName(String keyword){
		
			// 実行するSQL
				String sql = "SELECT * FROM book WHERE bookname LIKE ?";
				// ダメな例 String sql = "SELECT * FROM employee WHERE name LIKE %?%";
				// なぜなら値を埋め込むとSELECT * FROM employee WHERE name LIKE %'keyword'%となるから。​
				// 返却用のListインスタンス
				List<Book> result = new ArrayList<>();
				
				try (
						Connection con = getConnection();	// DB接続
						PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
						){
					
					// %や_はここで文字列結合する。そうすると'%keyword%'となる。
					pstmt.setString(1, "%" + keyword + "%");
					
					// SQL実行！
					// ResultSetもcloseする必要があるのでtry-with-resources文を使う
					try (ResultSet rs = pstmt.executeQuery()){
						
						// next()がfalseを返すまでループ
						while(rs.next()) {
		
							// n行目のデータを取得
							int id = rs.getInt("id");
							String BookName = rs.getString("bookname");
							String Name = rs.getString("name");
							String Syuppan = rs.getString("syuppan");
			
							Book commadity = new Book(id,BookName,Name, Syuppan);
							result.add(commadity);
						}
					}
		
		} catch (SQLException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				// Listを返却する。0件の場合は空のListが返却される。
				return result;
			}
}
