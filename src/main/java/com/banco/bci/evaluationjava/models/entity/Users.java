package com.banco.bci.evaluationjava.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder
@ToString
public class Users implements Serializable {

    @UuidGenerator
    @Column(name = "usr_id", columnDefinition = "CHAR(36)")
    @Id
    protected String id;

    @Column(name = "usr_email", nullable = false)
    private String email;

    @Column(name = "usr_password", nullable = false)
    private String password;

    @Column(name = "usr_created_date")
    private LocalDateTime createdDate;

    @Column(name = "usr_modified_date")
    private LocalDateTime modifiedDate;

    @UuidGenerator
    @Column(name = "usr_token", columnDefinition = "CHAR(36)")
    private String token;

    @Column(name = "usr_last_login")
    private LocalDateTime lastLogin;

    @Column(name = "usr_is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phone> phones;

}

