package co.edu.uco.bodyhealty.servicios.application.secondaryports.entity;

import java.util.UUID;

import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.servicios.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servicios")
public final class ServicioEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "servicio")
	private String nombreServicio;

	@Column(name = "duracion")
	private int duracionEstimada;

	@Column(name = "descripcion")
	private String descripcion;

	//TODO: APLICAR CAMBIOS A DURACIÓN ESTIMADA
	ServicioEntity(){
		setId(UUIDHelper.getDefault());
		setNombreServicio(TextHelper.EMPTY);
		setDuracionEstimada(duracionEstimada);
		setDescripcion(TextHelper.EMPTY);
	}


	public ServicioEntity(final UUID id, final String nombreServicio, final
			int duracionEstimada, final String descripcion) {
		setId(id);
		setNombreServicio(nombreServicio);
		setDuracionEstimada(duracionEstimada);
		setDescripcion(descripcion);
	}

	public static final ServicioEntity create() {
		return new ServicioEntity();
	}

	public static final ServicioEntity create(final UUID id, final String nombreServicio, final
			int duracionEstimada, final String descripcion) {
		return new ServicioEntity(id, nombreServicio, duracionEstimada, descripcion);
	}

	//TODO: CAMBIAR EL 0 por el helper
	public static final ServicioEntity create(final UUID id) {
		return new ServicioEntity(id, TextHelper.EMPTY, 0, TextHelper.EMPTY);
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}


	public String getNombreServicio() {
		return nombreServicio;
	}


	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = TextHelper.applyTrim(nombreServicio);
	}


	public int getDuracionEstimada() {
		return duracionEstimada;
	}


	public void setDuracionEstimada(int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
	}


	@Override
	public String toString() {
		return "ServicioEntity [id=" + id + ", nombreServicio=" + nombreServicio + ", duracionEstimada="
				+ duracionEstimada + ", descripcion=" + descripcion + "]";
	}







}
