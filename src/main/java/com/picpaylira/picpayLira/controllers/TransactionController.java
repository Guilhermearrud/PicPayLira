package com.picpaylira.picpayLira.controllers;

import com.picpaylira.picpayLira.domain.transaction.Transaction;
import com.picpaylira.picpayLira.dtos.TransactionDTO;
import com.picpaylira.picpayLira.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/check-authorization")
    public ResponseEntity<Boolean> checkAuthorization() {
        boolean body = transactionService.checkAuthorization();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }
}
