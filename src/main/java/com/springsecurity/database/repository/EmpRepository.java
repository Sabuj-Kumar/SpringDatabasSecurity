package com.springsecurity.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.database.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee,Integer>{

	public Employee findByEmail(String email);
}
