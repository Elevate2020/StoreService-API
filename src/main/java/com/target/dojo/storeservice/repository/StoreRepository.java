package com.target.dojo.storeservice.repository;

/**
 * Created by z063221 on 3/9/17.
 */

import com.target.dojo.storeservice.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByCityAndId(String city, Long id);

    List<Store> findByCity(String city);

}
