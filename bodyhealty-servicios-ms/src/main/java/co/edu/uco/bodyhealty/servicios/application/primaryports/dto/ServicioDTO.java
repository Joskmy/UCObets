package co.edu.uco.bodyhealty.servicios.application.primaryports.dto;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;

public final class ServicioDTO {
	private String nombreServicio;
	private int duracionEstimada;
	private String descripcion;

	public ServicioDTO(final String nombreServicio, final int duracionEstimada, final String descripcion) {
		setNombreServicio(nombreServicio);
		setDuracionEstimada(duracionEstimada);
		setDescripcion(descripcion);
	}

	public static final ServicioDTO create(final String nombreServicio, final int duracionEstimada,
			final String descripcion) {
		return new ServicioDTO(nombreServicio, duracionEstimada, descripcion);
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	private void setNombreServicio(final String nombreServicio) {
		this.nombreServicio = TextHelper.applyTrim(nombreServicio);
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
		this.descripcion = TextHelper.applyTrim(descripcion);
	}

	@Override
	public String toString() {
		return "ServicioDTO [nombreServicio=" + nombreServicio + ", duracionEstimada=" + duracionEstimada
				+ ", descripcion=" + descripcion + "]";
	}
	

}
