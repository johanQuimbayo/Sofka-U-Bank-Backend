package com.sofkau.count.services.transactions;



import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import com.sofkau.count.commons.transactions.dtos.entry.TransactionEntryDTO;


public interface ITransactionsServices {


    public AcountExitDTO deposit (TransactionEntryDTO transactionEntryDTO);

    public AcountExitDTO withdraw(TransactionEntryDTO transactionEntryDTO);


}
