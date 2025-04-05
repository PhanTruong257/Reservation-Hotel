package com.example.reservationhotel.dto;

import java.util.Set;

public class CountryDTO {
    private Long id;

    private String name;
    private Set<CityDTO> cities;

    public CountryDTO(Long id, String name, Set<CityDTO> cities) {

        this.name = name;
        this.cities = cities;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CityDTO> getCities() {
        return cities;
    }

    public void setCities(Set<CityDTO> cities) {
        this.cities = cities;
    }
}
