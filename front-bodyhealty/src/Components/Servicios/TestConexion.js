import React, { useEffect, useState } from 'react';
import { ServiciosService } from './ServiciosService';

function TestConexion() {
  const [estado, setEstado] = useState('Verificando...');
  const [datos, setDatos] = useState([]);

  useEffect(() => {
    const probarConexion = async () => {
      try {
        setEstado('Conectando...');
        const response = await ServiciosService.getServicios();
        console.log('Respuesta recibida:', response);
        
        if (response) {
          setEstado('Conexión exitosa');
          setDatos(response);
        }
      } catch (error) {
        console.error('Error de conexión:', error);
        setEstado(`Error: ${error.message}`);
      }
    };

    probarConexion();
  }, []);

  return (
    <div>
      <h2>Prueba de Conexión con la API</h2>
      <p>Estado: {estado}</p>
      
      {datos.length > 0 && (
        <div>
          <h3>Datos recibidos:</h3>
          <ul>
            {datos.map((item, index) => (
              <li key={index}>
                {item.nombre} - Duración: {item.duracion}
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default TestConexion; 