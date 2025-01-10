package com.sofkau.count.controllers.transaction;




import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import com.sofkau.count.commons.transactions.dtos.entry.TransactionEntryDTO;
import org.springframework.http.ResponseEntity;

public interface ITransactionController {

    public ResponseEntity<AcountExitDTO> deposit (TransactionEntryDTO transactionEntryDTO);

    public ResponseEntity<AcountExitDTO> withdraw(TransactionEntryDTO transactionEntryDTO);


}
