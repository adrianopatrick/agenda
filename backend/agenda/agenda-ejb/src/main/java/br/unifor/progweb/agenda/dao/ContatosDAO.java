package br.unifor.progweb.agenda.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.unifor.progweb.agenda.entitys.Contatos;

@Stateless
public class ContatosDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Contatos contato) {
		em.persist(contato);
	}
	
	public Contatos atualizar(Contatos contato) {
		return em.merge(contato);
	}
	
	public void remover(Contatos contato) {
		em.remove(contato);
	}
	
	public Contatos buscarPorId(Long id) {
		return em.find(Contatos.class, id);
	}
	
	public List<Contatos> buscarTodos(){
		String jpql = "select c from Contatos c";
		TypedQuery<Contatos> query = em.createQuery(jpql, Contatos.class);
		return query.getResultList();
	}
}
