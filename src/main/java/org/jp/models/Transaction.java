package org.jp.models;

import java.time.LocalDate;

public record Transaction(String transactionId, double amount, LocalDate date, TransactionType type) {}