package loja.orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import loja.orcamento.situacao.Analise;
import loja.orcamento.situacao.Finalizado;
import loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento implements Orcavel {
	
	private BigDecimal valor; 
	private SituacaoOrcamento situacao;
	private List<Orcavel> itens;
	
	public Orcamento() {
		this.valor = BigDecimal.ZERO;
		this.situacao = new Analise();
		this.itens = new ArrayList<>();
	}
	
	public void aplicarDescontoExtra() {
		BigDecimal  valorDoDescontoExtra = this.situacao.calcularValorDescnotoExtra(this);
		this.valor = this.valor.subtract(valorDoDescontoExtra);
	}
	
	
	
	public SituacaoOrcamento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}

	public void aprovar () {
		this.situacao.aprovar(this);
	}
	
	public void reprovar() {
		this.situacao.reprovar(this);
	}
	
	public void finalizar() {
		this.situacao.finalizar(this);
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getQuantidadeItens() {
		return itens.size();
	}

	public boolean isFinalizado() {
		return situacao instanceof Finalizado;
	}
	
	public void adicionarItem(Orcavel item) {
		this.valor = valor.add(item.getValor());
		this.itens.add(item);
	}

	
}
