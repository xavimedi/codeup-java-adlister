import java.io.Serializable;

public class Album implements Serializable {
	private long id;
	private String artist;
	private String name;
	private int date;
	private double sales_in_M;
	private String genre;

	public Album(long id, String artist, String name, int date, double sales_in_M, String genre) {
		this.id = id;
		this.artist = artist;
		this.name = name;
		this.date = date;
		this.sales_in_M = sales_in_M;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public double getSales_in_M() {
		return sales_in_M;
	}

	public void setSales_in_M(double sales_in_M) {
		this.sales_in_M = sales_in_M;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}