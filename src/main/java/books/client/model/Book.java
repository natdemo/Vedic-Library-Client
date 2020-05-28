package books.client.model;

public class Book {

	private String bookTitle;
	private String bookEnglishTitle;

	// @Field("type")
	private BookType bookType;

	public Book() {
	}

	public Book(String bookTitle, String bookEnglishTitle, BookType bookType) {
		this.bookTitle = bookTitle;
		this.bookEnglishTitle = bookEnglishTitle;
		this.bookType = bookType;

	}

	public String getBookTitle() {
		return bookTitle;
	}

	public Book setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
		return this;
	}

	public String getBookEnglishTitle() {
		return bookEnglishTitle;
	}

	public Book setBookEnglishTitle(String bookEnglishTitle) {
		this.bookEnglishTitle = bookEnglishTitle;
		return this;
	}

	public BookType getBookType() {
		return bookType;
	}

	public Book setBookType(BookType bookType) {
		this.bookType = bookType;
		return this;
	}

	@Override
	public String toString() {
		return "book [bookTitle=" + bookTitle + ", bookEnglishTitle=" + bookEnglishTitle + ", bookType=" + bookType
				+ "]";
	}

}
