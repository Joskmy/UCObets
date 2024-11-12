package co.edu.uco.bodyhealty.servicios.application.primaryports.dto;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;

public final class ServicioDTO {
	private String nombreServicio;
	private int duracionEstimada;
	private String descripcion;
	
	public ServicioDTO() {
        setNombreServicio(TextHelper.EMPTY);
        setDuracionEstimada(NumericHelper.ZERO);
        setDescripcion(TextHelper.EMPTY);	
    }
	
	public ServicioDTO(final String nombreServicio, final int duracionEstimada, final String descripcion) {
		setNombreServicio(nombreServicio);
		setDuracionEstimada(duracionEstimada);
		setDescripcion(descripcion);
		System.out.println("ServicioDTO creado ->   nombreServicio: " + nombreServicio + ", duracionEstimada: " + duracionEstimada + ", descripcion: " + descripcion);
	}

	public static final ServicioDTO create(final String nombreServicio, final int duracionEstimada,
			final String descripcion) {
		return new ServicioDTO(nombreServicio, duracionEstimada, descripcion);
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	private void setNombreServicio(final String nombreServicio) {
		this.nombreServicio = TextHelper.applyTrim(nombreServicio).toLowerCase();
	}

	public int getDuracionEstimada() {
		return duracionEstimada;
	}

	private void setDuracionEstimada(final int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(final String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion).toLowerCase();
	}

	@Override
	public String toString() {
		return "ServicioDTO [nombreServicio=" + nombreServicio + ", duracionEstimada=" + duracionEstimada
				+ ", descripcion=" + descripcion + "]";
	}


}
