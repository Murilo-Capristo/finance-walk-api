package br.com.fiap.finance_walk_api.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.fiap.finance_walk_api.model.User;
import br.com.fiap.finance_walk_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.finance_walk_api.model.Category;
import br.com.fiap.finance_walk_api.model.Transaction;
import br.com.fiap.finance_walk_api.model.TransactionType;
import br.com.fiap.finance_walk_api.repository.CategoryRepository;
import br.com.fiap.finance_walk_api.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DatabaseSeeder {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        var categories = List.of(
                Category.builder().name("Educação").icon("Book").build(),
                Category.builder().name("Lazer").icon("Dices").build(),
                Category.builder().name("Saúde").icon("Heart").build(),
                Category.builder().name("Transporte").icon("Bus").build());

        categoryRepository.saveAll(categories);

        var descriptions = List.of(
                "Supermercado",
                "Aluguel",
                "Internet",
                "Academia",
                "Transporte Público",
                "Cartão de Crédito",
                "Streaming (Netflix)",
                "Streaming (Spotify)",
                "Gasolina",
                "Manutenção do Carro",
                "Plano de Saúde",
                "Seguro do Carro",
                "Material Escolar",
                "Telefone Celular",
                "Restaurante",
                "Lazer (Cinema)",
                "Presentes",
                "Impostos",
                "Produtos de Limpeza",
                "Cuidados Pessoais");

        var transactions = new ArrayList<Transaction>();
        for (int i = 0; i < 50; i++) {
            transactions.add(
                    Transaction.builder()
                            .description(descriptions.get(new Random().nextInt(descriptions.size())))
                            .amount(BigDecimal.valueOf(10 + new Random().nextDouble() * 500))
                            .date(LocalDate.now().minusDays(new Random().nextInt(30)))
                            .type(TransactionType.EXPENSE)
                            .category(categories.get(new Random().nextInt(categories.size())))
                            .build()
                        );
        }

        transactionRepository.saveAll(transactions);

        userRepository.saveAll(List.of(
                User.builder()
                        .email("murilo@fiap.com.br")
                        .password(passwordEncoder.encode("12345"))
                        .role("ADMIN")
                        .build(),
                User.builder()
                        .email("rebecca@fiap.com.br")
                        .password(passwordEncoder.encode("54321"))
                        .role("USER")
                        .build()


        ));


    }

}
