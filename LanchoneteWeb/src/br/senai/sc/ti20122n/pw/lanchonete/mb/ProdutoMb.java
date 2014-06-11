package br.senai.sc.ti20122n.pw.lanchonete.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.senai.sc.ti20122n.pw.lanchonete.model.entity.Produto;
import br.senai.sc.ti20122n.pw.lanchonete.util.FacesContextUtil;

@ManagedBean
public class ProdutoMb {

	private List<Produto> produtos;
	private Produto produto;
	private EntityManager entityManager;

	@PostConstruct
	private void init() {
		produto = new Produto();
		entityManager = FacesContextUtil.getEntityManager();
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			Query query = entityManager.createQuery(
					"SELECT p FROM produto p", Produto.class);
			produtos = query.getResultList();
		}
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String salvar() {
			entityManager.merge(produto);
		return "listaProdutos";
	}

	public String editar(Long id) {
		produto = entityManager.find(Produto.class, id);
		return "cadastrarProduto";
	}
	
	public String excluir(Long id){
		entityManager.remove(entityManager.find(Produto.class, id));
		return "";
	}
}
