package com.example.reservationhotel.dto;

import java.util.Set;

public class CountryDTO {

    private String name;
    private Set<CityDTO> cities;  // Nếu bạn muốn bao gồm thông tin thành phố

    public CountryDTO(Long id, String name, Set<CityDTO> cities) {

        this.name = name;
        this.cities = cities;
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
