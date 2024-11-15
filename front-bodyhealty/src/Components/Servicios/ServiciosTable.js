import React from 'react';
import './ServiciosCrud.css';

const ServiciosTable = ({ 
  servicios, 
  onEdit, 
  onDelete, 
  searchTerm, 
  searchDuration 
}) => {
  const filteredServicios = servicios.filter(servicio => {
    const matchesName = servicio.nombreServicio.toLowerCase().includes(searchTerm.toLowerCase());
    const matchesDuration = !searchDuration || servicio.duracionEstimada === parseInt(searchDuration);
    return matchesName && matchesDuration;
  });

  return (
    <table>
      <thead>
        <tr>
          <th>Id</th>
          <th>Nombre</th>
          <th>Duración</th>
          <th>Descripción</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        {filteredServicios.map((servicio, index) => (
          <tr key={servicio.id}>
            <td>{index + 1}</td>
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
  );
};

export default ServiciosTable;