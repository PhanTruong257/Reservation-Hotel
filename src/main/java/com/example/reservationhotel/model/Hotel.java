package com.example.reservationhotel.model;

import com.example.reservationhotel.model.audit.DateAudit;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "hotel_chain_id")
    private HotelChain hotelChain;

    @Column(nullable = false)
    private int rating;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Room> rooms;

    @ManyToMany
    @JoinTable(
            name = "hotel_features",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<HotelFeature> features;
}
