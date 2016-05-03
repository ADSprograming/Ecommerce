package ClassesBasicas;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Produto {
	@Id
	private int idProduto;
	private double preco;
	private String nome,descricao,marca;
	@ManyToMany(mappedBy="produtos")
	private Set<Compra> compras;
	public Set<Compra> getCompras() {
		return compras;
	}
	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}
	public int getId() {
		return idProduto;
	}
	public void setId(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
