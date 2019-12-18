package com.github.murilloandrade.lojas.configuracao;

import com.github.murilloandrade.lojas.modelo.*;
import com.github.murilloandrade.lojas.modelo.enums.*;
import com.github.murilloandrade.lojas.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class Instanciacao implements CommandLineRunner {
    @Autowired
    IRepositorioProduto iRepositorioProduto;

    @Autowired
    IRepositorioLoja iRepositorioLoja;

    @Override
    public void run(String... args) throws Exception {
        Loja loja = new Loja();
        loja.setNome("Star Chic");
        loja.setEstado("Goiás");
        loja.setCidade("Goiânia");
        loja.setBairro("Centro");
        loja.setEndereco("Rua Alguma Coisa Eu Não Lembro");

        Produto produto = new Produto();
        produto.setFornecedor(Fornecedor.Fornecedor1);
        produto.setLoja(loja);
        produto.setDescricao("Aposta com o Paulo");
        produto.setPrecoCompra(20.25);
        produto.setPrecoVenda(25.55);
        produto.setEstoque(10);

        System.out.println(iRepositorioLoja.save(loja));
        System.out.println(iRepositorioProduto.save(produto));
    }
}
