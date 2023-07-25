package dao;

import com.mysql.cj.jdbc.Driver;
import models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

	public static void main(String[] args) {
		MySQLAdsDao dao = new MySQLAdsDao(new Config());
		List<Ad> ads = dao.all();
		for(int i = 0; i < ads.size(); i++){
			System.out.println(ads.get(i).getTitle());
			System.out.println(ads.get(i).getDescription());
		}
	}

	private Connection connection;

	public MySQLAdsDao(Config config) {
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(
					config.getUrl(),
					config.getUser(),
					config.getPassword()
			);
		} catch (SQLException e) {
			throw new RuntimeException("error connecting to database", e);
		}
	}

	@Override
	public List<Ad> all() {
		List<Ad> ads = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
			while (rs.next()) {
				ads.add(new Ad(
						rs.getLong("id"),
						rs.getLong("user_id"),
						rs.getString("title"),
						rs.getString("description")
				));
			}
			return ads;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Long insert(Ad ad) {
		try {
			Statement stmt = connection.createStatement();
			long result = stmt.executeUpdate("INSERT INTO ads(user_id, title, description) VALUES (" + ad.getId() + ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')");
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}