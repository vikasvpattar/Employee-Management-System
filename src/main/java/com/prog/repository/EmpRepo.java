package com.prog.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.entity.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{


}
