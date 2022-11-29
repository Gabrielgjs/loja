package loja.orcamento.situacao;

import java.math.BigDecimal;

import loja.orcamento.Orcamento;

public class OrcamentoProxy  extends Orcamento{
	private BigDecimal valor;
	private Orcamento orcamento;
	
	public OrcamentoProxy(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
	@Override
	public BigDecimal getValor() {
		if(valor == null) {
			this.valor = orcamento.getValor();
		}
		
		return this.valor;	
	}
	
}
