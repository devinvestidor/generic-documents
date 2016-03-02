package br.com.documento.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.documentos.dao.GenericDAO;
import br.com.documentos.entidades.Documento;
import br.com.documentos.entidades.Setor;


@ManagedBean
@ViewScoped
public class DocumentoMB extends GenericMB<Documento> {

	@Override
	void instanciaObjeto() {
		objeto = new Documento();
		
	}	
	
	public List<Setor> getListaSetor(){
		GenericDAO<Setor> setorDAO = new GenericDAO<Setor>();
		return setorDAO.listar("Setor");
	}
	
	public void realizaTrocaSetor(){		
		dao.editar(objeto);		
	}

}