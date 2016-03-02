package br.com.documentos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.documentos.util.JpaUtil;

public class GenericDAO<T> {	
	
	public enum Operacoes{
		INSERIR(1), EDITAR(2), EXCLUIR(3);
		
		public int valorOperacao;
		Operacoes(int valor){
			valorOperacao = valor;			
		}		
	}	
	
	private EntityManager em = JpaUtil.getEntityManager();
	
	
	public void inserir(T entity){
		realizaOperacoes(entity, Operacoes.INSERIR);
	}
	
	public void editar(T entity){
		realizaOperacoes(entity, Operacoes.EDITAR);
	}
	
	public void excluir(T entity){
		realizaOperacoes(entity, Operacoes.EXCLUIR);
	}		
	
	public List<T> listar(String entity){				
		return em.createQuery("SELECT m FROM " + entity +  " m").getResultList();
	}	
		
	
	public void realizaOperacoes(T entity, Operacoes operacao){
		em.getTransaction().begin();
		
		try {
			if(operacao == Operacoes.INSERIR){
				em.persist(entity);
			}else if(operacao == Operacoes.EDITAR){
				em.merge(entity);
			}else if(operacao == Operacoes.EXCLUIR){
				em.remove(entity);
			}		
			em.getTransaction().commit();			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}		
	}
	
	

}
