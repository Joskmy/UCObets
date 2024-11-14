import React from 'react';
import './ServiciosCrud.css';

const ServicioForm = ({
  nombre,
  duracion,
  descripcion,
  setNombre,
  setDuracion,
  setDescripcion,
  handleSubmit,
  formMode,
  onCancel
}) => {
  const isEditing = formMode === 'edit';
  
  return (
    <div className="form-container">
      <div className="form-header">
        <h2>{isEditing ? 'Actualizar Servicio' : 'Registrar Servicio'}</h2>
      </div>
      <div className="form-content">
        <div className="input-group">
          <label>Nombre del servicio</label>
          <input
            type="text"
            placeholder="Ingrese el nombre del servicio"
            value={nombre}
            onChange={(e) => setNombre(e.target.value)}
            className="form-input"
          />
        </div>
        <div className="input-group">
          <label>Duración</label>
          <select
            value={duracion}
            onChange={(e) => setDuracion(e.target.value)}
            className="form-input"
          >
            <option value="">Seleccione la duración</option>
            {Array.from({ length: 20 }, (_, i) => (i + 1) * 15).map(minutos => (
              <option key={minutos} value={minutos}>
                {minutos} minutos
              </option>
            ))}
          </select>
        </div>
        <div className="input-group">
          <label>Descripción</label>
          <textarea
            placeholder="Ingrese la descripción del servicio"
            value={descripcion}
            onChange={(e) => setDescripcion(e.target.value)}
            className="form-input textarea"
            rows={4}
          />
        </div>
        <div className="button-group">
          <button onClick={handleSubmit} className="submit-button">
            {isEditing ? 'Actualizar' : 'Registrar'} Servicio
          </button>
          <button onClick={onCancel} className="cancel-button">
            Cancelar
          </button>
        </div>
      </div>
    </div>
  );
};

export default ServicioForm; 