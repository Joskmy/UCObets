package co.edu.uco.bodyhealty.servicios.application.responses.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.servicios.application.primaryports.dto.ServicioDTO;
import co.edu.uco.bodyhealty.servicios.application.responses.Response;

public class ServicioResponse extends Response<ServicioDTO> {

	public static final ServicioResponse build(final List<String> mensajes,final List<ServicioDTO> datos) {
		ServicioResponse instance = new ServicioResponse();
		instance.setMensajes(mensajes);
		instance.setDatos(datos);

		return instance;
	}


	public static final ServicioResponse build(final List<ServicioDTO> datos) {
		ServicioResponse instance = new ServicioResponse();
		instance.setMensajes(new ArrayList<>());
		instance.setDatos(datos);

		return instance;
	}

	public static final ServicioResponse build() {
		ServicioResponse instance = new ServicioResponse();
		instance.setMensajes(new ArrayList<>());
		instance.setDatos(new ArrayList<>());

		return instance;
	}
}