package com.target.dojo.storeservice.domain;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by z063221 on 4/12/17.
 */
public class StoreTest {

    @Test
    public void whenAllArgsConstructorUsed_thenObjectCreatedCorrectly(){

        Store store = new Store().builder()
                                .city("Lino Lakes")
                                .name("Lake Store")
                                .address("749 Apollo Dr")
                                .zip((long) 55014)
                                .id((long) 1448)
                                .build();

        assertThat(store.getCity(), is("Lino Lakes"));
        assertThat(store.getName(), is("Lake Store"));
        assertThat(store.getAddress(), is("749 Apollo Dr"));
        assertThat(store.getZip(), is((long) 55014));
        assertThat(store.getId(), is((long) 1448));
    }

    @Test
    public void whenNoArgsConstructorUsed_thenObjectCreatedCorrectly(){

        Store store = new Store();

        store.setId((long) 643);
        store.setName("Apple Valley Store");
        store.setCity("Apple Valley");
        store.setAddress("15150 Cedar Ave");
        store.setZip((long) 55124);

        assertThat(store.getCity(), is("Apple Valley"));
        assertThat(store.getName(), is("Apple Valley Store"));
        assertThat(store.getAddress(), is("15150 Cedar Ave"));
        assertThat(store.getZip(), is((long) 55124));
        assertThat(store.getId(), is((long) 643));
    }

}
