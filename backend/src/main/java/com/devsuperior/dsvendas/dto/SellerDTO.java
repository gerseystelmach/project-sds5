package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.entities.Seller;

import java.io.Serializable;
/* Implemento o serialize para garantir que meus objetos serão convertidos em bytes, para ser salvo em arquivos, etc. */
public class SellerDTO implements Serializable {

    private Long id;
    private String name;

    public SellerDTO() {

    }
    public SellerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
/* Busco facilmente os elementos de uma entidade para o DTO com esse construtor.
Não preciso usar o this.id, pois não existe risco de confusão com o nome dos atributos, pois o parâmetro é uma entidade */
    public SellerDTO(Seller entity) {
       id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
