import React, { useState } from 'react';
import './CreateCity.css'; // Importar archivo de estilos

const CreateCity = () => {
  const [cityName, setCityName] = useState('');
  const [stateId, setStateId] = useState('');
  const [error, setError] = useState('');

  // Estados disponibles con sus UUIDs
  const states = [
    { id: '1e4d2e2a-1c4b-4a6b-9a2d-1a2b3c4d5e60', name: 'Antioquia' },
    { id: '3b09d136-7dd1-4a2c-998a-210e016cee67', name: 'Cundinamarca' },
    { id: '2e4d2e2a-1c4b-4a6b-9a2d-1a2b3c4d5e61', name: 'Valle del Cauca' }
  ];

  // Expresión regular para validar un UUID
  const isValidUUID = (id) => {
    const uuidRegex = /^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$/;
    return uuidRegex.test(id);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Validar que el ID del estado sea un UUID válido
    if (!isValidUUID(stateId)) {
      setError('El ID del estado debe tener un formato UUID válido.');
      return;
    }

    // Validar que el estado exista
    const selectedState = states.find(state => state.id === stateId);
    if (!selectedState) {
      setError('El ID del estado no corresponde a un estado válido.');
      return;
    }

    // Preparar los datos para enviar
    const cityData = {
      cityName: cityName,
      stateId: stateId
    };

    try {
      const response = await fetch('http://localhost:8080/general/api/v1/cities', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(cityData)
      });

      if (!response.ok) {
        throw new Error(`Error: ${response.status} ${response.statusText}`);
      }

      // Mostrar mensaje de éxito
      alert('Ciudad creada exitosamente');
      setError('');
    } catch (error) {
      // Mostrar mensaje de error con alert
      alert(`Error al crear la ciudad: ${error.message}`);
    }
  };

  return (
    <div className="create-city-container">
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={cityName}
          onChange={(e) => setCityName(e.target.value)}
          placeholder="Nombre de la ciudad"
          required
        />

        <label htmlFor="stateId">ID del Estado (Formato UUID o elija uno)</label>
        <input
          type="text"
          id="stateId"
          value={stateId}
          onChange={(e) => setStateId(e.target.value)}
          placeholder="Escribe el ID del estado o selecciona uno"
          list="statesList" // Asociamos el datalist con este input
          required
        />
        
        {/* Datalist con los estados predefinidos */}
        <datalist id="statesList">
          {states.map((state) => (
            <option key={state.id} value={state.id}>
              {state.name}
            </option>
          ))}
        </datalist>

        {error && <p className="error">{error}</p>}

        <button type="submit">Crear Ciudad</button>
      </form>
    </div>
  );
};

export default CreateCity;
