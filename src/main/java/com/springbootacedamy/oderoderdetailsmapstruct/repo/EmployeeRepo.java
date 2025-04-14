package com.springbootacedamy.oderoderdetailsmapstruct.repo;


import com.springbootacedamy.oderoderdetailsmapstruct.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {


}
