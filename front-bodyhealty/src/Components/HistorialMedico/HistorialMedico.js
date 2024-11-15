import React, { useState } from 'react';
import axios from 'axios';

function HistorialMedico() {
  const [estado, setEstado] = useState('No conectado');
  const [error, setError] = useState(null);

  const axiosInstance = axios.create({
    baseURL: 'http://localhost:8080/general/api/v1/services',
    auth: { 
      username: 'user', 
      password: '123456' 
    },
    headers: {
      'Content-Type': 'application/json'
    }
  });

  // Probar conexión GET
  const probarConexion = async () => {
    try {
      setEstado('Conectando...');
      console.log('Intentando conexión GET...');
      const response = await axiosInstance.get('/?nombre=e');
      console.log('Respuesta:', response.data);
      setEstado('Conexión exitosa');
      setError(null);
    } catch (err) {
      console.error('Error completo:', err);
      setEstado('Error de conexión');
      setError(err.message);
    }
  };

  return (
    <div className="container mt-4">
      <h2>Prueba de Conexión API</h2>
      
      <div className="card mt-3">
        <div className="card-body">
          <h5 className="card-title">Estado de la conexión</h5>
          <p className="card-text">
            Estado: <span className={`badge ${estado.includes('exitosa') ? 'bg-success' : 'bg-warning'}`}>
              {estado}
            </span>
          </p>
          {error && (
            <div className="alert alert-danger">
              Error: {error}
            </div>
          )}
        </div>
      </div>

      <button 
        className="btn btn-primary mt-3"
        onClick={probarConexion}
      >
        Probar Conexión
      </button>
    </div>
  );
}

export default HistorialMedico;