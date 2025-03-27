package com.example.reservationhotel;

import com.example.reservationhotel.security.auth.JwtAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReservationHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationHotelApplication.class, args);
	}
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

}
