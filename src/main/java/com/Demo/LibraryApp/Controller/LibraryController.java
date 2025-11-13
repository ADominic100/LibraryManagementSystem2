package com.Demo.LibraryApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.LibraryApp.Entity.Book;
import com.Demo.LibraryApp.Entity.Member;
import com.Demo.LibraryApp.Service.LibraryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class LibraryController {
	
    @Autowired
	LibraryService ls;
    
	/*
	 * @GetMapping("/") public String showHome() { return "show"; }
	 */
    
    
    
//Adding new member
    @PostMapping("/members")
    public String addMember(@RequestBody Member member) {

    	return ls.addMember(member);
    }
//Get all members 
   @GetMapping("/members")
   public List<Member> getAllMembers(){
	  return  ls.getAllMembers();
   }
   
 //Get  single member
    @GetMapping("/members/{id}")
    public Member getMemberById(@PathVariable int id) {
    	Member member = ls.getMemberById(id);
    	
    	if(member==null) {throw new RuntimeException("Member not found");}
    	
    	return  member;
    	
    }
  
//Update Member  
    
    @PutMapping("/members/{id}")
    public String updateMember(@PathVariable int id,@RequestBody Member m1) {
    	return ls.updateMember(id, m1);
    }


//Adding book
   
    @PostMapping("/books")
    public String addBook(@RequestBody Book book) {

    	return ls.addBook(book);
    }
    
//Get all books 
    @GetMapping("/books")
    public List<Book> getAllBooks(){
 	  return  ls.getAllBooks();
    }
    
 //Get  a book//
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
    	Book book = ls.getBookById(id);
    	
    	if(book==null) {throw new RuntimeException("Book not found");}
    	
    	return  book;
    	
    }
    
//Update Book  
    
    @PutMapping("/books/{id}")
    public String updateBook(@PathVariable int id,@RequestBody Book b1) {
    	return ls.updateBook(id, b1);
    }
    
//Delete a book
    
    @DeleteMapping("/books/{id}")
    public String deleteBookbyId(@PathVariable int id) {
    	return ls.deleteBookbyId(id);
    }
    
 //Borrow a book
    
    @PostMapping("/borrow/{bookId}/member/{memberId}")
    public String borrowBook(@PathVariable int bookId,@PathVariable int memberId) {
    	return ls.borrowBook(bookId,memberId);
    }
    
 //Return a book
    
    @PostMapping("/return/{bookId}")
    public String returnBook(@PathVariable int bookId) {
    	return ls.returnBook(bookId);
    }

}
