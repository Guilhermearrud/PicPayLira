package com.picpaylira.picpayLira.repositories;

import com.picpaylira.picpayLira.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
