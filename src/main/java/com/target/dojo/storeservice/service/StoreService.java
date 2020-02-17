package com.target.dojo.storeservice.service;

/**
 * Created by z063221 on 3/9/17.
 */

import com.target.dojo.storeservice.domain.Store;

import java.util.List;

public interface StoreService {

    Store getStore(String city, Long id);

    List<Store> getStoreList(String city);

}