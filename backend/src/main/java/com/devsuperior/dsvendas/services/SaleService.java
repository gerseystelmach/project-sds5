package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    /* Isso garante que toda a operação com o db seja resolvida no serviço e o readonly serve para não fazer lock no banco de dados */
    @Transactional(readOnly = true)
    /* Aplicando o atributo pageable, consigo criar paginação facilmente na view */
    public Page<SaleDTO> findAll(Pageable pageable) {
        /*Trazendo para memoria a lista de vendedores para armazenar em cache e evitar fazer varias requisicoes na base de dados */
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }
}
