package com.teefactory.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teefactory.demo.dto.PessoaDTO;
import com.teefactory.demo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("select p.nome from Pessoa p")
    List<String> buscarNomes();

    @Query("""
             select new com.teefactory.demo.dto.PessoaDTO(p.nome, p.email, e.rua, e.numero, e.bairro)from Pessoa p
              join p.enderecos e""")
    List<PessoaDTO> pessoas();
}
