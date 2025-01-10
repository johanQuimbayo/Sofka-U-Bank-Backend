package com.sofkau.count.converters.transactions;

import com.sofkau.count.commons.transactions.dtos.entry.TransactionEntryDTO;
import com.sofkau.count.commons.users.dtos.entry.UserEntryDTO;
import com.sofkau.count.domain.acounts.model.Acount;
import com.sofkau.count.domain.transactions.model.Transaction;


public interface ITransactionMapper {

    public Transaction mapToTransaction(TransactionEntryDTO transactionEntryDTO, Acount acount);
}
