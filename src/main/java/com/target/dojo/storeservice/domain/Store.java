package com.target.dojo.storeservice.domain;

/**
 * Created by z063221 on 3/9/17.
 */

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="TBL_STORE")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Store {

    @Id
    private Long id;

    private String city;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Long zip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }



}
