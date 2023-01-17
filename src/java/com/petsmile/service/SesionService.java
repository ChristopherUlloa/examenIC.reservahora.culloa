package com.petsmile.service;

import com.petsmile.model.Usuario;

public interface SesionService {
	Usuario validarUsuario(String user, String password);
}
