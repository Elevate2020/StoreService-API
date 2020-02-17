package com.target.dojo.storeservice.service;

import com.target.dojo.storeservice.domain.Store;
import com.target.dojo.storeservice.repository.StoreRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by z063221 on 4/13/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceImplTest {

    private StoreService storeService;
    private StoreRepository storeRepository;
    private Store store;

    @Before
    public void doSetup() {

        storeRepository = Mockito.mock(StoreRepository.class);
        storeService = new StoreServiceImpl(storeRepository);
    }

    @Test
    public void WhenGetHotelMethodCalled_thenReteturnsHotelObject() {

        store =  new Store().builder()
                .id ((long) 825)
                .city("Peoria")
                .name("Peoria Store")
                .address("8055 W Bell Rd")
                .zip((long) 85382)
                .build();

        Mockito.when(storeRepository.findByCityAndId("Peoria", (long) 825)).thenReturn(store);

        Store retrievedStore = storeService.getStore("Peoria", (long) 825);

        assertThat(store.getId(),is(retrievedStore.getId()));

    }

    @Test
    public void getStoreListTest() {

        store =  new Store().builder()
                .id ((long) 825)
                .city("BLR")
                .name("Blr Store")
                .address("Manyata Blr")
                .zip((long) 560087)
                .build();
        List<Store> storeList = new ArrayList<>();
        storeList.add(store);

        Mockito.when(storeRepository.findByCity("BLR")).thenReturn(storeList);

        List<Store> retrievedStore = storeService.getStoreList("BLR");

        assertThat(retrievedStore instanceof List, is (true));
        assertThat(store.getId(),is(retrievedStore.get(0).getId()));

    }
}