import React from 'react';
import './ServiciosCrud.css';

const ServiciosTable = ({ 
  servicios = [], 
  onEdit, 
  onDelete, 
  searchTerm, 
  searchDuration 
}) => {
  if (!Array.isArray(servicios)) {
    console.error('servicios no es un array:', servicios);
    return <p>Error: Los datos no tienen el formato esperado</p>;
  }

  const filteredServicios = servicios.filter(servicio => {
    if (!servicio || typeof servicio !== 'object') return false;
    
    const matchesName = servicio.nombreServicio?.toLowerCase().includes((searchTerm || '').toLowerCase());
    const matchesDuration = !searchDuration || servicio.duracionEstimada === parseInt(searchDuration);
    return matchesName && matchesDuration;
  });

  return (
    <>
      {filteredServicios.length === 0 ? (
        <p>No se encontraron servicios</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Duración</th>
              <th>Descripción</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {filteredServicios.map((servicio) => (
              <tr key={servicio.id}>
                <td>{servicio.nombreServicio}</td>
                <td>{servicio.duracionEstimada} min</td>
                <td>{servicio.descripcion}</td>
                <td className="actions">
                  <button 
                    className="action-btn edit" 
                    onClick={() => onEdit(servicio)}
                  >
                    ✏️
                  </button>
                  <button 
                    className="action-btn delete" 
                    onClick={() => onDelete(servicio.id)}
                  >
                    ❌
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </>
  );
};

export default ServiciosTable;