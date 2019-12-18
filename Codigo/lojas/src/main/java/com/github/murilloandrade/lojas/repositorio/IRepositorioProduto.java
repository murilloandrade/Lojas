package com.github.murilloandrade.lojas.repositorio;

import com.github.murilloandrade.lojas.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioProduto extends JpaRepository<Produto, Long> {
    List<Produto> findByDescricaoContainingIgnoreCase(String texto);
}
