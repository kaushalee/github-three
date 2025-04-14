package com.springbootacedamy.oderoderdetailsmapstruct.repo;

import com.springbootacedamy.oderoderdetailsmapstruct.entity.ItemEntity;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.OderDetailsEntity;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.OderEntity;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@EnableJpaRepositories

public interface OderDetailsRepo extends JpaRepository<OderDetailsEntity, Integer> {


    List<OderDetailsEntity> findAllByOderEntityEquals(OderEntity referenceById);


    List<OderDetailsEntity> findAllByItemEntityEquals(ItemEntity referenceById);
}
