package com.sofkau.count.data.transactions.repository;



import com.sofkau.count.data.transactions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transaction, Integer> {


}
