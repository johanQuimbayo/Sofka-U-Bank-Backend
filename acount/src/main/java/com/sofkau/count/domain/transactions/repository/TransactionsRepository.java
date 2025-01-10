package com.sofkau.count.domain.transactions.repository;



import com.sofkau.count.domain.transactions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionsRepository extends JpaRepository<Transaction, Integer> {


}
