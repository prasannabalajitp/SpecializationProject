package com.th.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.th.constants.PropertyConstant;
import com.th.model.Book;
import com.th.repository.BookRepository;
/**
 * BookController class allows you to add, delete, get and find a book by id
 * @author Rohith S
 *
 */
@RestController
@RequestMapping(PropertyConstant.BOOKS)
public class BookController {
	
	
	@Autowired
	BookRepository bookRepository;
	
	
	/**
	 * Save function helps you to add a book in the database
	 * @param book 
	 * @return ResponseEntity<Book> returns the properties of the book passes in the parameter
	 */ 
	@PostMapping(PropertyConstant.BOOK)
	public ResponseEntity<Book> save (@RequestBody Book book){
		
		Book bookSaved = bookRepository.save(book);
		return new ResponseEntity<Book>(bookSaved,HttpStatus.OK);
	}
	
	/**
	 * getAllBooks function helps you to retreive all the books from the database
	 * @return ResponseEntity<List<Book>> list of books
	 */
	 
	@GetMapping(PropertyConstant.GET_ALL_BOOKS)
	public  ResponseEntity<List<Book>> getAllBooks(){
		
		List<Book> bookList = bookRepository.findAll();
		return new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
	}
	
	
	/**
	 * getBookById helps you find a book by its ID
	 * @param bookId id the unique identity of a book
	 * @return ResponseEntity<Book> returns a single book with all its properties else returns not found
	 *
	 */
	@GetMapping(PropertyConstant.FIND_BOOK)
	public ResponseEntity<Book> getBookById(@PathVariable int bookId){
		
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		if(bookOptional.isPresent()) {
			Book bookFound = bookOptional.get();
			return new ResponseEntity<Book>(bookFound,HttpStatus.OK);
			
		}
		else
			return new  ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		
	}

	
	/**
	 * deleteBookById deletes a book from the database
	 * @param bookId id the unique identity of a book 
	 * @return ResponseEntity<Book> no content else returns not found 
	 */
	@DeleteMapping(PropertyConstant.DELETE_BOOK)
	public ResponseEntity<Book> deleteBookById(@PathVariable int bookId){
		if(bookRepository.existsById(bookId)) {
			bookRepository.deleteById(bookId);
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	
	
}
