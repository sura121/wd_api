package com.weedoctor.api.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="USERS")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk;

    @Column(nullable = true, length = 20)
    private String phoneNumber;

    @Column(nullable = true, length = 10)
    private String name;

    @Column
    private Date removedAt;


}
