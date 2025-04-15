package br.com.fiap.finance_walk_api.model;

import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionFilter(String description, LocalDate startDate, LocalDate endDate) {


}
