package com.springbootacedamy.oderoderdetailsmapstruct.repo;

import com.springbootacedamy.oderoderdetailsmapstruct.entity.CustomEntity;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.OderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@EnableJpaRepositories
public interface OderRepo extends JpaRepository<OderEntity,Integer> {
    boolean existsByOderIdEqualsAndActiveStateEquals(int oderId, boolean b);


    List<OderEntity> findAllByCustomEntityEquals(CustomEntity referenceById);


    List<OderEntity> findAllByActiveStateEquals(boolean activeState);
}
