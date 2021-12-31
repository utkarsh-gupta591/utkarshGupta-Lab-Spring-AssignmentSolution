package com.greatlearning.collegefest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.collegefest.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}
