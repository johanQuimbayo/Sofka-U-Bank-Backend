package com.sofkau.count.data.transactions.model;


import com.sofkau.count.data.acounts.model.Acount;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions_logs")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private  Integer id;

    @Column(name = "acount_number")
    private Integer acountNumber;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "is_successful")
    private Boolean isSuccessful;

    @Column(name = "date_time")
    private Date dateTime;


    @ManyToOne
    @JoinColumn(name = "id_acount", nullable=false)
    private Acount acount;
}
