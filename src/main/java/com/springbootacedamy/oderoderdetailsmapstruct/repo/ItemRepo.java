package com.springbootacedamy.oderoderdetailsmapstruct.repo;


import com.springbootacedamy.oderoderdetailsmapstruct.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<ItemEntity,Integer> {



    List<ItemEntity> findAllByActiveStateEquals(boolean activeState);

    List<ItemEntity> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);
}
