package com.sistemaa.sistemaa.services;

import com.sistemaa.sistemaa.model.Pessoa;
import com.sistemaa.sistemaa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }
}
