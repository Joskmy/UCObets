import React, { useEffect, useState } from 'react';
import { ServiciosService } from '../Servicios/ServiciosService';

function HistorialMedico() {
  const [estado, setEstado] = useState('Iniciando...');
  const [servicios, setServicios] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    probarConexion();
  }, []);

  const probarConexion = async () => {
    try {
      setEstado('Conectando con la API...');
      const response = await ServiciosService.getServicios();
      setServicios(response);
      setEstado('Conexión exitosa');
      setError(null);
    } catch (err) {
      console.error('Error de conexión:', err);
      setEstado('Error de conexión');
      setError(err.message);
    }
  };

  return (
    <div className="container mt-4">
      <h2>Historial Médico - Prueba de Conexión</h2>
      
      <div className="card mt-3">
        <div className="card-body">
          <h5 className="card-title">Estado de la conexión</h5>
          <p className="card-text">
            Estado actual: <span className="badge bg-success">{estado}</span>
          </p>
          {error && (
            <div className="alert alert-danger">
              Error: {error}
            </div>
          )}
        </div>
      </div>

      {servicios.length > 0 && (
        <div className="card mt-3">
          <div className="card-body">
            <h5 className="card-title">Servicios Disponibles ({servicios.length})</h5>
            <div className="table-responsive">
              <table className="table table-hover">
                <thead>
                  <tr>
                    <th>Nombre del Servicio</th>
                    <th>Duración (min)</th>
                    <th>Descripción</th>
                  </tr>
                </thead>
                <tbody>
                  {servicios.map((servicio, index) => (
                    <tr key={index}>
                      <td>{servicio.nombre}</td>
                      <td>{servicio.duracion || 'No especificada'}</td>
                      <td>{servicio.descripcion || '-'}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      )}

      <div className="mt-3">
        <button 
          className="btn btn-primary me-2"
          onClick={probarConexion}
        >
          <i className="fas fa-sync-alt"></i> Actualizar Lista
        </button>
      </div>
    </div>
  );
}

export default HistorialMedico;