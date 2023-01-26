package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Account;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class AccountDAO {
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
	
	public static int registerAccount(Account account) {
		String sql = "INSERT INTO account VALUES(default, ?, ?, ?, ?, current_timestamp)";
		int result = 0;
		
		// ランダムなソルトの取得(今回は32桁で実装)
		String salt = GenerateSalt.getSalt(32);
		
		// 取得したソルトを使って平文PWをハッシュ
		String hashedPw = GenerateHashedPw.getSafetyPassword(account.getPassword(), salt);
		
		System.out.println("登録時のソルト:" + salt);
		System.out.println("登録時のハッシュ:" + hashedPw);
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getMel());
			pstmt.setString(3, salt);
			pstmt.setString(4, hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	// メールアドレスを元にソルトを取得
	public static String getSalt(String mel) {
		String sql = "SELECT salt FROM account WHERE mel = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mel);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ログイン処理
	public static Account login(String mel, String hashedPw) {
		String sql = "SELECT * FROM account WHERE mel = ? AND password = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mel);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String salt = rs.getString("salt");
					String createdAt = rs.getString("created_at");
					
					return new Account(id, name, mel, salt, null, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
