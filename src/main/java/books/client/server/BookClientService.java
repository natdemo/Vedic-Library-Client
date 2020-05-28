package books.client.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import books.client.model.Book;

@RestController
@RequestMapping("/api")
public class BookClientService {

	@Autowired
	private RestTemplate restTemplate;

	private String REQUEST_URI = "http://vedic-book-service/api/books";

	@GetMapping("/books")
	@HystrixCommand(fallbackMethod = "getAllBooksFallBack")
	@ResponseBody
	public  List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		ResponseEntity<Book[]> res = restTemplate.getForEntity(REQUEST_URI, Book[].class);
		for(Book b : res.getBody()) {
			bookList.add(b);
		}
		return bookList;
	}

	@GetMapping("books/{id}")
	@HystrixCommand(fallbackMethod = "getBookFallBack")
	@ResponseBody
	public Book getBook(@PathVariable("id") String bookId) {
		ResponseEntity<Book> res = restTemplate.getForEntity(REQUEST_URI + "/{id}", Book.class, bookId);
		return (Book) res.getBody();
	}

	public List<Book> getAllBooksFallBack() {	
		List<Book> bookList = new ArrayList<Book>();
		Book book = new Book().setBookTitle("Vedic Book Library Server is down.  Please try back later!");
	
		bookList.add(book);
		return bookList;
	}
	
	public Book getBookFallBack(@PathVariable("id") String bookId) {	
		return new Book().setBookTitle("Vedic Book Library Server is down.  Please try back later!");
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
