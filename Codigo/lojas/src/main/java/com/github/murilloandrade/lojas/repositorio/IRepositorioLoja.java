package com.github.murilloandrade.lojas.repositorio;

import com.github.murilloandrade.lojas.modelo.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioLoja extends JpaRepository<Loja, Long> {
}
