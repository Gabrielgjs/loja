package loja.application;

import java.math.BigDecimal;

import loja.orcamento.Orcamento;
import loja.orcamento.situacao.ItemOrcamento;
import loja.orcamento.situacao.OrcamentoProxy;

public class TesteComposicao {

	public static void main(String[] args) {

		Orcamento antigo = new Orcamento();
		antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		antigo.reprovar();
		
		Orcamento novo = new Orcamento();
		novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		novo.adicionarItem(antigo);
		
		OrcamentoProxy proxy = new OrcamentoProxy(novo);
		
		
		System.out.println(proxy.getValor());
	}

}
