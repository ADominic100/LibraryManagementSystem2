package com.Demo.LibraryApp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.LibraryApp.Entity.Member;



public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	

}
