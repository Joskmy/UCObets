package co.edu.uco.bodyhealty.servicios.domain.servicio;

import java.util.UUID;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.domain.Domain;

public final class ServicioDomain extends Domain {

	private String nombreServicio;
	private int duracionEstimada;
	private String descripcion;
	public ServicioDomain(final UUID id, final String nombreServicio,
			final int duracionEstimada, final String descripcion) {
		super(id);
		setNombreServicio(nombreServicio);
		setDuracionEstimada(duracionEstimada);
		setDescripcion(descripcion);
	}
	
	public static ServicioDomain build(UUID id) {
	    return new ServicioDomain(id, TextHelper.EMPTY, NumericHelper.ZERO, TextHelper.EMPTY);
	}
	
	public static ServicioDomain buildForQuery(UUID id) {
	    return new ServicioDomain(id, TextHelper.EMPTY, NumericHelper.ZERO, TextHelper.EMPTY);
	}
	
	public String getNombreServicio() {
		return nombreServicio;
	}
	private void setNombreServicio(final String nombreServicio) {
		this.nombreServicio = nombreServicio;
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
		this.descripcion = descripcion;
	}
	
}
