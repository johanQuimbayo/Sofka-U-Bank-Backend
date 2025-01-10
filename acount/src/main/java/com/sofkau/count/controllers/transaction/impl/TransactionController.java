package com.sofkau.count.controllers.transaction.impl;



import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import com.sofkau.count.commons.transactions.dtos.entry.TransactionEntryDTO;
import com.sofkau.count.controllers.transaction.ITransactionController;
import com.sofkau.count.services.transactions.ITransactionsServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController implements ITransactionController {


    @Autowired
    private ITransactionsServices iTransactionsServices;


    @Override
    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AcountExitDTO> deposit(@Valid @RequestBody TransactionEntryDTO transactionEntryDTO) {
         return ResponseEntity.ok(iTransactionsServices.deposit(transactionEntryDTO));
    }


    @Override
    @PostMapping("/withdraw")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AcountExitDTO> withdraw(@Valid @RequestBody TransactionEntryDTO transactionEntryDTO) {
        return ResponseEntity.ok(iTransactionsServices.withdraw(transactionEntryDTO));
    }

}
