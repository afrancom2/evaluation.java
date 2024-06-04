package com.banco.bci.evaluationjava.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "phone")
@Builder
@ToString
public class Phone implements Serializable {

    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(name = "phn_id", columnDefinition = "CHAR(36)")
    @Id
    protected String id;

    @Column(name = "phn_number")
    private String number;

    @Column(nullable = false, name = "phn_city_code")
    private String cityCode;

    @Column(nullable = false, name = "phn_country_code")
    private String countryCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    private Users users;

}

