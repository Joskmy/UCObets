import React, { useState } from 'react';
import { GoogleOAuthProvider } from '@react-oauth/google';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Login from './Components/Login/Login';
import SideBar from './Components/SideBar/SideBar';
import AgendarCita from './Components/AgendarCita/AgendarCita';
import ConsultarCitas from './Components/ConsultarCitas/ConsultarCitas';
import HistorialMedico from './Components/HistorialMedico/HistorialMedico';
import Servicios from './Components/Servicios/Servicios';
import Soporte from './Components/Soporte/Soporte';
import './App.css';

const CLIENT_ID = '723482709922-4r4nfln40di3g98msfs9a5k00odepri9.apps.googleusercontent.com';

const App = () => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  const handleLoginSuccess = (response) => {
    console.log('Login Exitoso:', response);
    setIsAuthenticated(true);
  };

  const handleLoginFailure = (error) => {
    console.error('Login Fallido:', error);
    setIsAuthenticated(false);
  };

  return (
    <GoogleOAuthProvider clientId={CLIENT_ID}>
      <div className="App">
        {!isAuthenticated ? (
          <Login onSuccess={handleLoginSuccess} onError={handleLoginFailure} />
        ) : (
          <Router>
            <div className="authenticated-content">
              <SideBar />
              <Routes>
                <Route path="/agendar-cita" element={<AgendarCita />} />
                <Route path="/consultar-citas" element={<ConsultarCitas />} />
                <Route path="/historial-medico" element={<HistorialMedico />} />
                <Route path="/servicios" element={<Servicios />} />
                <Route path="/soporte" element={<Soporte />} />
                <Route path="/" element={<Navigate to="/agendar-cita" />} />
              </Routes>
            </div>
          </Router>
        )}
      </div>
    </GoogleOAuthProvider>
  );
};

export default App;