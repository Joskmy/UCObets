package co.edu.uco.bodyhealty.servicios.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.UUIDHelper;

public final class ServicioDTO {
	private UUID id;
	private String nombreServicio;
	private int duracionEstimada;
	private String descripcion;
	
	public ServicioDTO() {
		setId(UUIDHelper.getDefault());
        setNombreServicio(TextHelper.EMPTY);
        setDuracionEstimada(NumericHelper.ZERO);
        setDescripcion(TextHelper.EMPTY);	
    }
	
	public ServicioDTO(final UUID id, final String nombreServicio, final int duracionEstimada, final String descripcion) {
		setId(id);
		setNombreServicio(nombreServicio);
		setDuracionEstimada(duracionEstimada);
		setDescripcion(descripcion);
	}

	public static final ServicioDTO create(final UUID id, final String nombreServicio, final int duracionEstimada,
			final String descripcion) {
		return new ServicioDTO(id, nombreServicio, duracionEstimada, descripcion);
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(final String nombreServicio) {
		this.nombreServicio = TextHelper.applyTrim(nombreServicio).toLowerCase();
	}

	public int getDuracionEstimada() {
		return duracionEstimada;
	}

	public void setDuracionEstimada(final int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion).toLowerCase();
	}

}
