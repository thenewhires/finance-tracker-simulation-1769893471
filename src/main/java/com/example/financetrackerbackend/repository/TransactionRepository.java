package com.example.financetrackerbackend.repository;

import com.example.financetrackerbackend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
