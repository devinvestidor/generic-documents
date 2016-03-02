package br.com.documentos.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.documentos.entidades.Documento;
import br.com.documentos.entidades.Setor;


@FacesConverter(value="converterSetor")
public class ConverterSetor implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		List<Setor> setores = (List<Setor>) arg1.getAttributes().get("lista");
		for (Setor setor : setores) {
			if(setor.getDescricao().equals(arg2)){
				return setor;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Setor setor = (Setor) arg2;
		return setor.getDescricao();
	}

}
