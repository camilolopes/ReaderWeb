package com.camilolopes.readerweb.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.camilolopes.readerweb.model.bean.Type;

@FacesConverter( value= "com.camilolopes.readerweb.TypeConverter",forClass=Type.class)
public class TypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Type type =	new Type();
		type.setId(Long.valueOf(value));
		return type;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
			if(value!=null){
				return ((Type)value).getId().toString();
			}
		return null;
	}


}
