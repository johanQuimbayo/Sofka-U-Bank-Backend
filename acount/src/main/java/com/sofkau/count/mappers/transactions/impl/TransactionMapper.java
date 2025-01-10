package com.sofkau.count.mappers.transactions.impl;

import com.sofkau.count.commons.transactions.dtos.entry.TransactionEntryDTO;
import com.sofkau.count.mappers.transactions.ITransactionMapper;
import com.sofkau.count.data.acounts.model.Acount;
import com.sofkau.count.data.transactions.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionMapper implements ITransactionMapper {
    @Override
    public Transaction mapToTransaction(TransactionEntryDTO transactionEntryDTO, Acount acount) {
        if (transactionEntryDTO == null) {
            throw new IllegalArgumentException("transactionEntryDTO can´t be empty");
        }
        return Transaction.builder()
                .acountNumber(transactionEntryDTO.getAcountNumber())
                .amount(transactionEntryDTO.getAmount())
                .isSuccessful(true)
                .dateTime(new Date())
                .acount(acount)
                .build();


    }
}
