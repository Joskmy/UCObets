import axios from 'axios';
import { useState } from 'react';

function HistorialMedico() {
  const [respuesta, setRespuesta] = useState(null);
  const [error, setError] = useState(null);

  // Usa la misma URL que funciona en Postman
  const API_URL = 'https://7ga2e9l7b7.execute-api.us-east-1.amazonaws.com/pruebapost/general/api/v1/services';

  const obtenerServicios = async () => {
    try {
      console.log('Iniciando petición a:', API_URL);
      
      const response = await axios.get(API_URL, {
        headers: {
          'Content-Type': 'application/json',
          'ngrok-skip-browser-warning': 'true'
        }
      });

      console.log('Respuesta exitosa:', response.data);
      setRespuesta(response.data);
      setError(null);
    } catch (err) {
      console.error('Error completo:', err);
      console.error('Estado de la respuesta:', err.response?.status);
      console.error('Datos del error:', err.response?.data);
      setError(`Error: ${err.message}`);
      setRespuesta(null);
    }
  };

  return (
    <div>
      <h2>Prueba de Conexión</h2>
      <button onClick={obtenerServicios}>Probar Conexión</button>
      
      {error && (
        <div style={{color: 'red', margin: '10px 0'}}>
          {error}
        </div>
      )}
      
      {respuesta && (
        <div style={{margin: '20px 0'}}>
          <h3>Conexión exitosa:</h3>
          <pre style={{whiteSpace: 'pre-wrap'}}>
            {JSON.stringify(respuesta, null, 2)}
          </pre>
        </div>
      )}
    </div>
  );
}

export default HistorialMedico;