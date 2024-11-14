import React from 'react';
import ServiciosCrud from './ServiciosCrud';
import './Servicios.css';

const Servicios = () => {
  return (
    <div className="servicios">
      <h2>Servicios Disponibles</h2>
      <div className="servicios-container">
        <ServiciosCrud />
      </div>
    </div>
  );
};

export default Servicios;