package br.com.fiap.finance_walk_api.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.fiap.finance_walk_api.model.TransactionFilter;
import br.com.fiap.finance_walk_api.specification.TransactionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.finance_walk_api.model.Transaction;
import br.com.fiap.finance_walk_api.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/transactions")
@Slf4j
public class TransactionController {



    @Autowired
    private TransactionRepository repository;

    @GetMapping
    public Page<Transaction> index(TransactionFilter filter, @PageableDefault(size=10, sort="datecd " , direction = Sort.Direction.DESC) Pageable pageable){
        return repository.findAll(TransactionSpecification.withFilters(filter), pageable);










//        log.info("Buscando transações com descrição {} e data {}", filter.description(), filter.date());
//
////        var probe = Transaction.builder()
////                        .description(filter.description)
////                        .date(filter.date())
////                        .amount(filter.amount())
////                        .build();
////
////        var matcher = ExampleMatcher.matchingAll()
////                        .withIgnoreCase()
////                        .withIgnoreNullValues()
////                        .withStringMatcher(StringMatcher.CONTAINING);
//
//       var example = Example.of(probe, matcher);
//
//        return repository.findAll(example);
    }
    
}
