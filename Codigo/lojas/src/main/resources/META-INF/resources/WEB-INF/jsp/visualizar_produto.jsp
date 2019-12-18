<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lojas</title>
    <style>
        body {background-color: black; color: aqua;}
        tr {color: aqua; border-style: solid; border-color:aqua;}
        input { border-style: solid; border-color:aqua;}
        form:select { border-style: solid; border-color:aqua;}
    </style>
</head>
<body>
<div align="center">
    <h2>Lojas</h2>

    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Buscar" />
    </form>

    <h3><a href="/produto/new">Novo Produto</a></h3>

    <table border="1" cellpadding="5">
        <tr>
            <th>Estoque</th>
            <th>Descrição</th>
            <th>Fornecedor</th>
            <th>Preço de Compra</th>
            <th>Preço de Venda</th>
            <th>Loja</th>
            <th>Ação</th>
        </tr>
        <c:forEach items="${listProdutos}" var="produto">
            <tr>
                <td>${produto.estoque}</td>
                <td>${produto.descricao}</td>
                <td>${produto.fornecedor}</td>
                <td>${produto.precoCompra}</td>
                <td>${produto.precoVenda}</td>
                <td>${produto.loja}</td>
                <td>
                   <a href="/produto/edit?id=${produto.id}">Editar</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/produto/delete?id=${produto.id}">Deletar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>