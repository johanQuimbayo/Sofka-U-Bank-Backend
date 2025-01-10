package com.sofkau.count.mappers.transactions;

import com.sofkau.count.commons.transactions.dtos.entry.TransactionEntryDTO;
import com.sofkau.count.data.acounts.model.Acount;
import com.sofkau.count.data.transactions.model.Transaction;


public interface ITransactionMapper {

    public Transaction mapToTransaction(TransactionEntryDTO transactionEntryDTO, Acount acount);
}
