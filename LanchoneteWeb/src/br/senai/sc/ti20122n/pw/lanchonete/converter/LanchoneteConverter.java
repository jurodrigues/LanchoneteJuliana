package br.senai.sc.ti20122n.pw.lanchonete.converter;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.ti20122n.pw.lanchonete.mb.LanchoneteMb;
import br.senai.sc.ti20122n.pw.lanchonete.model.entity.Lanchonete;


@FacesConverter(forClass=Lanchonete.class)
public class LanchoneteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		ELContext elContext = facesContext.getELContext();
		ELResolver elResolver = elContext.getELResolver();
		
		LanchoneteMb lanchoneteMb = (LanchoneteMb) elResolver.getValue(elContext, null, "LanchoneteMb");
		
		Long id = Long.parseLong(value);
		return lanchoneteMb.buscarLanchonetePorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
		Lanchonete lanche = (Lanchonete) object;
		return String.valueOf(lanche.getId());
	}

}
