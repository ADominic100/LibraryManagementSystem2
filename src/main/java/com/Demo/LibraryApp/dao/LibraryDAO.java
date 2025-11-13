package com.Demo.LibraryApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Demo.LibraryApp.Entity.Book;
import com.Demo.LibraryApp.Entity.Member;
import com.Demo.LibraryApp.Repository.MemberRepository;
import com.Demo.LibraryApp.Repository.BookRepository;

@Repository
public class LibraryDAO {

	@Autowired
	MemberRepository mRepo;
	@Autowired
	BookRepository bRepo;

	public String addMember(Member member) {

	
			mRepo.save(member);

			return "Added successfullly...";
		
	}

	public List<Member> getAllMembers() {
		
		return mRepo.findAll();
	}

	public Member getMemberById(int id) {
		
		return mRepo.findById(id).get();
	}

	public String updateMember(int id, Member m1) {
		Member existingMember = mRepo.findById(id).get();
		if(existingMember!=null) {
			existingMember.setName(m1.getName());
		    existingMember.setEmail(m1.getEmail());	
		    mRepo.save(existingMember);
		    return "Updated";
		}
		else {
		return "Member not found";}
	}

	public String addBook(Book book) {
		
		 bRepo.save(book);

		return "Added successfullly...";
	}
	
	public List<Book> getAllBooks() {
		
		return bRepo.findAll();
	}
public Book getBookById(int id) {
		
		return bRepo.findById(id).get();
	}


public String updateBook(int id, Book b1) {
	Book existingBook = bRepo.findById(id).get();
	if(existingBook!=null) {
		existingBook.setAuthor(b1.getAuthor());;
		existingBook.setTitle(b1.getTitle());;	
	    bRepo.save(existingBook);
	    return "Updated";
	}
	else {
	return "Book not found";}
}

public String deleteBookbyId(int id) {
	//bRepo.deleteById(id);
	
	//return "deleted";
	
	Book existingBook = bRepo.findById(id).get();
	if(existingBook!=null) {
		bRepo.deleteById(id);
	    return "Deleted";
	}
	else {
	return "Book not found";}
}

public String borrowBook(int bookId, int memberId) {
	
	Book existingBook = bRepo.findById(bookId).get();
	Member existingMember = mRepo.findById(memberId).get();
	if(existingBook==null) {
		return "Book is not available. Please try later*****";
	
	}
	if(existingMember==null) {
		return "Only members can borrow book*****";
	
	}
	if(existingBook.isBorrowed()) {
		return "Please try later since Book is already taken";
	}
	existingBook.setBorrowed(true);
	return "Happy Reading!!!Return it onTime";
}

public String returnBook(int bookId) {
	Book existingBook = bRepo.findById(bookId).get();
	if(existingBook==null) {
		return "Book is not available. Please try later*****";
	
	}
	if(!existingBook.isBorrowed()) {
		return "Book is not borrowed";
	}
	existingBook.setBorrowed(false);
	return "Successfully Returned. Thank you!!!";
}
}