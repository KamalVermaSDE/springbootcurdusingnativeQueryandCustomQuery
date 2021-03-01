package com.springbootcurdoperationusingjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbootcurdoperationusingjpa.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
	@Query(value = "Select * from Instructor where id=:id", nativeQuery = true)
	Instructor getInstructorById(@Param("id") long id);

	@Query("select ins from InstructorDetails ins where ins.firstName=?1")
	List<Instructor> getInstructorByFirstName(@Param("firstName") String firstName);
	
	
	List<Instructor> findByName(@Param("lastName") String lastName);
}
