package br.com.livraria.model;
public class Publicidade {

	public String gerarTextoPromocional(Produto produto){
		
		return "Promo��o de " + produto.getClass().getName() + ".\n" + 
		       produto.getDescricao() + " por R$ " + produto.calcularPrecoVenda() +
		       "\nAproveite!";
	}
	
}
