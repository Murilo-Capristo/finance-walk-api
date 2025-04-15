package br.com.fiap.finance_walk_api.specification;

import br.com.fiap.finance_walk_api.model.Transaction;
import br.com.fiap.finance_walk_api.model.TransactionFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class TransactionSpecification {
    public static Specification<Transaction> withFilters(TransactionFilter filter){
        return (root, query, cb) -> {
            List<Predicate> predicades = new ArrayList<>();

            if (filter.description() != null) {
                predicades.add( cb.like(
                        cb.lower(root.get("description")), "%" + filter.description().toLowerCase() + "%"));
            }

            if (filter.startDate() != null && filter.endDate() != null){
                predicades.add(
                        cb.between(root.get("date"), filter.startDate(), filter.endDate())
                );
            }

            if(filter.startDate() !=null && filter.endDate() == null){
                predicades.add(
                        cb.equal(root.get("date"), filter.startDate()));
            }

            var arrayPredicades = predicades.toArray(new Predicate[0]);

            return cb.and(arrayPredicades);

            //Predicado
        };
    }
}
