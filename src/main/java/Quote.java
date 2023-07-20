import java.io.Serializable;

public class Quote implements Serializable {
	private long id;
	private String author;
	private String quote;

	public Quote() {
	}

	public Quote(long id, String author, String quote) {
		this.id = id;
		this.author = author;
		this.quote = quote;
	}

	public Quote(String author, String quote) {
		this.author = author;
		this.quote = quote;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
}
