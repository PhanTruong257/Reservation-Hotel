package com.example.reservationhotel.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonPropertyOrder({"success", "message", "status", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL) // Bỏ qua field null khi serialize
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 7702134516418120340L;

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private int status;  // Chuyển từ HttpStatus -> int để dễ serialize

    @JsonProperty("data")
    private T data;

    public ApiResponse(Boolean success, String message, int status) {
        this.success = success;
        this.message = message;
        this.status = status;
    }

    public ApiResponse(Boolean success, String message, int status, T data) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
