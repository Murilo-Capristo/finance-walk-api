package br.com.fiap.finance_walk_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.finance_walk_api.model.Transaction;
import br.com.fiap.finance_walk_api.model.TransactionFilter;
import br.com.fiap.finance_walk_api.repository.TransactionRepository;
import br.com.fiap.finance_walk_api.specification.TransactionSpecification;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/transactions")
@Slf4j
public class TransactionController {

    @Autowired
    private TransactionRepository repository;

    @GetMapping
    public Page<Transaction> index(TransactionFilter filter,
            @PageableDefault(size = 10, sort = "date", direction = Direction.DESC) Pageable pageable) {
        return repository.findAll(TransactionSpecification.withFilters(filter), pageable);
    }

}
