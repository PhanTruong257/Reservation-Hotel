package com.example.reservationhotel.model;

import com.example.reservationhotel.model.audit.DateAudit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking; // Thanh toán thuộc về 1 đơn đặt phòng

    @Column(nullable = false)
    private double amount; // Số tiền thanh toán

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status = PaymentStatus.PENDING; // Trạng thái thanh toán

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod method; // Phương thức thanh toán (VISA, PAYPAL, ...)

    private String transactionId; // Mã giao dịch (nếu có)
}
