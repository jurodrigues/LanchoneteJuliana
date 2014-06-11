package br.senai.sc.ti20122n.pw.lanchonete.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.ti20122n.pw.lanchonete.model.entity.Lanchonete;
import br.senai.sc.ti20122n.pw.lanchonete.util.FacesContextUtil;

@ManagedBean
public class LanchoneteMb {
	private List<Lanchonete> lanchonetes;
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		entityManager = FacesContextUtil.getEntityManager();
	}

	public List<Lanchonete> getLanchonetes() {
		if (lanchonetes == null) {
			Query query = entityManager.createQuery(
					"SELECT l FROM Lanchonete l", Lanchonete.class);
			lanchonetes = query.getResultList();
		}
		return lanchonetes;
	}

	public void setLanchonetes(List<Lanchonete> lanchonetes) {
		this.lanchonetes = lanchonetes;
	}

	public Lanchonete buscarLanchonetePorId(Long id) {
		return entityManager.find(Lanchonete.class, id);
	}

}
