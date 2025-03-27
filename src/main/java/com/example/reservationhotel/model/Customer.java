package com.example.reservationhotel.model;
import com.example.reservationhotel.model.audit.DateAudit;
import com.example.reservationhotel.model.role.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "email" })
})
public class Customer extends DateAudit {  // Kế thừa DateAudit

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank

    private String firstName;

    @NotBlank

    private String lastName;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @NotBlank

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String phone;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider = AuthProvider.LOCAL;

    private String providerId;

    @ManyToOne
    @JoinColumn(name = "city_code")
    private City city;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings;

}

