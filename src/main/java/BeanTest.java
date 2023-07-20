import java.util.ArrayList;

public class BeanTest {
	public static void main(String[] args) {

		Album album1 = new Album(212, "Machine Girl", "...Because I'm Young Arrogant and Hate Everything You Stand For", 2017, 5.2, "Rock");
		Album album2 = new Album(2, "Death Grips", "Powers that B", 2015, 7.8, "Pop");

		Author author1 = new Author(1, "Fyodor Dostoyevsky", "Russian fella");
		Author author2 = new Author(2, "John Greene", "Weird but smart guy");

		Quote quote1 = new Quote(8, "Charles Oliveira", "I am illuminated by God");
		Quote quote2 = new Quote(14, "Israel Adesanya", "I dare to be great, therefore I am ");

		ArrayList<Quote> quotes = new ArrayList<>();
		quotes.add(quote1);
		quotes.add(quote2);

		for (Quote quote : quotes){
			System.out.println("Author: " + quote.getAuthor());
			System.out.println("Quote: " + quote.getQuote() + "\n");
		}

		ArrayList<Author> authors = new ArrayList<>();
		authors.add(author1);
		authors.add(author2);

		for (Author author : authors){
			System.out.println("Author: " + author.getName());
			System.out.println("Description: " + author.getDescription() + "\n");
		}

		ArrayList<Album> albums = new ArrayList<>();
		albums.add(album1);
		albums.add(album2);

		for (Album album : albums){
			System.out.println("Artist: " + album.getArtist());
			System.out.println("Album: " + album.getName());
			System.out.println("Year: " + album.getDate());
			System.out.println("Release Date: " + album.getDate());
			System.out.println("Genre: " + album.getGenre() + "\n");
		}
	}
}