package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAll() {

        List<Seller> result = repository.findAll();
        /* Expressão lambda. Map vai converter minha coleção em outra coleção.
        Para cada X da minha lista original, quero criar um novo objeto seller,
        usando o X como argumento do construtor do SellerDTO. Após, converto a stream para uma List */
        return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }
}
