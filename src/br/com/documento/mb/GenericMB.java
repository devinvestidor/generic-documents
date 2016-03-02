package br.com.documento.mb;

import java.util.ArrayList;
import br.com.documento.mb.*;
import java.util.List;

import br.com.documentos.dao.GenericDAO;
import br.com.documentos.entidades.GenericEntity;

public abstract class GenericMB<T> {
	
	GenericDAO<T> dao;
	public T objeto;
	List<T> objetos;
	
	public GenericMB(){
		dao = new GenericDAO<T>();
		objetos = new ArrayList<T>();
		instanciaObjeto();
		listaObjeto();
	}
	
	abstract void instanciaObjeto();	
	
	public void salvarObjeto(){		
		if( ((GenericEntity) objeto).getId() == 0 ){
			dao.inserir(objeto);
			MessagesView.inclusao();			
		}else{
			dao.editar(objeto);
			MessagesView.edicao();		
		}
		listaObjeto();
		limpaObjeto();
	}

	
	public void excluiObjeto(){
		dao.excluir(objeto);
		MessagesView.exclusao();
		listaObjeto();
		limpaObjeto();
	}
	
	public void listaObjeto(){
		objetos = dao.listar(objeto.getClass().getSimpleName());
	}
	
	public void limpaObjeto(){
		instanciaObjeto();
	}	


	
	
	//Gets and Sets
	public GenericDAO<T> getDao() {
		return dao;
	}

	public void setDao(GenericDAO<T> dao) {
		this.dao = dao;
	}

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	public List<T> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<T> objetos) {
		this.objetos = objetos;
	}
	
	


}
