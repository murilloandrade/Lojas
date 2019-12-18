<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
    <h2>Novo Produto</h2>
    <form:form action="save" method="post" modelAttribute="produto">
        <table border="0" cellpadding="5">
            <tr>
                <td>Descrição: </td>
                <td><form:input path="descricao" required="required"/></td>
            </tr>
            <tr>
                <td>Estoque: </td>
                <td><form:input path="estoque" required="required"/></td>
            </tr>
            <tr>
                <td>Preço de Compra: </td>
                <td><form:input path="precoCompra" required="required"/></td>
            </tr>
            <tr>
                <td>Preço de Venda: </td>
                <td><form:input path="precoVenda" required="required"/></td>
            </tr>
            <tr>
                <td>Fornecedor: </td>
                <td><form:select name="FornecedorProduto" path="fornecedor" items="${fornecedores}">
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>