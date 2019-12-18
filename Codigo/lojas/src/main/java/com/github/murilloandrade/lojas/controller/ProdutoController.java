package com.github.murilloandrade.lojas.controller;

import com.github.murilloandrade.lojas.modelo.*;
import com.github.murilloandrade.lojas.modelo.enums.*;
import com.github.murilloandrade.lojas.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private IRepositorioProduto repositorioProduto;

    @Autowired
    private IRepositorioLoja repositorioLoja;

    @RequestMapping("/")
    public ModelAndView home() {
        List<Produto> listProdutos = repositorioProduto.findAll();
        ModelAndView mav = new ModelAndView("visualizar_produto");
        mav.addObject("listProdutos", listProdutos);
        return mav;
    }

    @RequestMapping("/new")
    public String newProdutoForm(Map<String, Object> model) {
        Produto produto = new Produto();
        model.put("produto", produto);
        model.put("fornecedores", Fornecedor.values());
        return "novo_produto";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduto(@ModelAttribute("produto") Produto produto) {
        Loja loja = repositorioLoja.findById((long) 1).get();
        produto.setLoja(loja);
        repositorioProduto.save(produto);
        return "redirect:/produto/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateProduto(@ModelAttribute("produto") Produto produto) {
        Loja loja = repositorioLoja.findById((long) 1).get();
        produto.setLoja(loja);
        repositorioProduto.save(produto);
        return "redirect:/produto/";
    }

    @RequestMapping("/edit")
    public ModelAndView editProdutoForm(@RequestParam long id, Map<String, Object> model) {
        ModelAndView mav = new ModelAndView("edit_produto");
        Loja loja = repositorioLoja.findById((long) 1).get();
        Produto produto = repositorioProduto.getOne(id);
        mav.addObject("produto", produto);
        model.put("produto", produto);
        model.put("fornecedores", Fornecedor.values());
        return mav;
    }

    @RequestMapping("/delete")
    public String deleteProdutoForm(@RequestParam long id) {
        Loja loja = repositorioLoja.findById((long) 1).get();
        Produto produto = repositorioProduto.findById(id).get();
        repositorioProduto.deleteById(id);
        return "redirect:/produto/";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Produto> result = repositorioProduto.
                findByDescricaoContainingIgnoreCase(keyword);
        ModelAndView mav = new ModelAndView("resultado_busca");
        mav.addObject("result", result);
        return mav;
    }
}
