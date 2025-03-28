package com.example.reservationhotel.exception;

import com.example.reservationhotel.dto.ApiResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private final ApiResponse apiResponse;

    public BadRequestException(ApiResponse apiResponse) {
        super(apiResponse.getMessage());
        this.apiResponse = apiResponse;
    }

    public BadRequestException(String message) {
        super(message);
        this.apiResponse = new ApiResponse(false, message, 400);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
        this.apiResponse = new ApiResponse(false, message, 400);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }
}
