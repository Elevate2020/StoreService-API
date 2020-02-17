package com.target.dojo.storeservice.service;

/**
 * Created by z063221 on 3/9/17.
 */

import com.target.dojo.storeservice.domain.Store;
import com.target.dojo.storeservice.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;

@Service

public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store getStore(String city, Long id) {
        Assert.notNull(city, "City must not be null");
        Assert.notNull(id, "Name must not be empty");
        return this.storeRepository.findByCityAndId(city, id);
    }

    @Override
    public List<Store> getStoreList(String city) {
        Assert.notNull(city, "City must not be null");
        return this.storeRepository.findByCity(city);
    }

}
