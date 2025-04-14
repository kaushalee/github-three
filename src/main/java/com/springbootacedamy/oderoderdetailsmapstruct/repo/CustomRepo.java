package com.springbootacedamy.oderoderdetailsmapstruct.repo;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.CustomResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.CustomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomRepo extends JpaRepository<CustomEntity,Integer> {


    List<CustomEntity> findAllByActiveStateEquals(boolean activeState);

    List<CustomEntity> findAllByCusomerSalaryEqualsAndActiveStateEquals(double cusomerSalary, boolean b);

}
