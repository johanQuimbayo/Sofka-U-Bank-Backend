package com.sofkau.count.data.acounts.model;


import com.sofkau.count.data.transactions.model.Transaction;
import com.sofkau.count.data.users.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acounts")
public class Acount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acount")
    private  Integer id;

    @Column(name = "acount_number")
    private Integer acountNumber;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable=false)
    private User user;

    @OneToMany(mappedBy="acount")
    private List<Transaction> transactions;
}
