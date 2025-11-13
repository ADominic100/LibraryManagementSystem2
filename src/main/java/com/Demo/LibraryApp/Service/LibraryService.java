package com.Demo.LibraryApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.LibraryApp.Entity.Book;
import com.Demo.LibraryApp.Entity.Member;
import com.Demo.LibraryApp.dao.LibraryDAO;

@Service
public class LibraryService {
	
	@Autowired
	LibraryDAO ldao;

	public String addMember(Member member) {
		
		return ldao.addMember(member);
	}

	public List<Member> getAllMembers() {
		return ldao.getAllMembers();
		
	}

	public Member getMemberById(int id) {
		
		return ldao.getMemberById(id);
	}

	public String updateMember(int id, Member m1) {
		
		return ldao.updateMember(id, m1);
	}

	public String addBook(Book book) {
		
		 return ldao.addBook(book);
	}

	public List<Book> getAllBooks() {
		
		 return ldao.getAllBooks();
	}
    
   public Book getBookById(int id) {
		
		return ldao.getBookById(id);
	}
   public String updateBook(int id, Book b1) {
		
		return ldao.updateBook(id, b1);
	}
   public String deleteBookbyId(int id) {
	   return ldao.deleteBookbyId(id);
   }

public String borrowBook(int bookId, int memberId) {
	
	return ldao.borrowBook(bookId,memberId);
}

public String returnBook(int bookId) {
	
	return ldao.returnBook(bookId);
	
	
}
}
