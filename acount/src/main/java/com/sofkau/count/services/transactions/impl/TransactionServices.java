package com.sofkau.count.services.transactions.impl;



import com.sofkau.count.commons.acounts.dtos.exit.AcountExitDTO;
import com.sofkau.count.exceptions.NotFoundException;
import com.sofkau.count.commons.transactions.dtos.entry.TransactionEntryDTO;
import com.sofkau.count.converters.acounts.IAcountMapper;
import com.sofkau.count.converters.transactions.ITransactionMapper;
import com.sofkau.count.domain.acounts.model.Acount;
import com.sofkau.count.domain.acounts.repository.AcountsRepository;
import com.sofkau.count.domain.transactions.repository.TransactionsRepository;
import com.sofkau.count.services.transactions.ITransactionsServices;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServices implements ITransactionsServices {

    @Autowired
    AcountsRepository acountsRepository;

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    IAcountMapper iAcountMapper;

    @Autowired
    ITransactionMapper iTransactionMapper;


    @Override
    @Transactional
    public AcountExitDTO deposit(TransactionEntryDTO transactionEntryDTO) {
        if (transactionEntryDTO.getAmount() <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }

        Acount acount = acountsRepository.findByAcountNumber(transactionEntryDTO.getAcountNumber()).orElseThrow(
                () -> new NotFoundException("Account not found")
        );

        acount.setBalance(acount.getBalance() + transactionEntryDTO.getAmount());
        acountsRepository.save(acount);

        transactionsRepository.save(iTransactionMapper.mapToTransaction(transactionEntryDTO, acount));

        return iAcountMapper.mapAcounttoAcountExit(acount);

    }

    @Override
    @Transactional
    public AcountExitDTO withdraw(TransactionEntryDTO transactionEntryDTO) {
        if (transactionEntryDTO.getAmount() <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }

        Acount acount = acountsRepository.findByAcountNumber(transactionEntryDTO.getAcountNumber()).orElseThrow(
                () -> new NotFoundException("Account not found")
        );

        if (acount.getBalance() < transactionEntryDTO.getAmount()) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        acount.setBalance(acount.getBalance() - transactionEntryDTO.getAmount());
        acountsRepository.save(acount);

        transactionsRepository.save(iTransactionMapper.mapToTransaction(transactionEntryDTO, acount));

        return iAcountMapper.mapAcounttoAcountExit(acount);
    }
}
