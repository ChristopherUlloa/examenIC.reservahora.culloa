package com.petsmile.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SesionUtil {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}
}
