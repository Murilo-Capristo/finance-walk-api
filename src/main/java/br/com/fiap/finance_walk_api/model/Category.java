package br.com.fiap.finance_walk_api.model;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Category{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    @Size(min = 3, max = 30, message = "deve ter pelo menos 3 caracteres")
    private String name;
    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "^[A-Z].*", message = "O icone deve começar com letra maiúscula")
    private String icon;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", icon=" + icon + "]";
    }

  

}
