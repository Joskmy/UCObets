import React from 'react';
import { useNavigate } from 'react-router-dom';
import './SideBar.css';
import { 
  FaCalendarPlus, 
  FaCalendarAlt, 
  FaFileAlt, 
  FaStore, 
  FaCog, 
  FaUser, 
  FaSearch 
} from 'react-icons/fa';
import { FiLogOut } from 'react-icons/fi';

const Sidebar = () => {
  const navigate = useNavigate();

  const handleNavigation = (path) => {
    navigate(path);
  };

  return (
    <div className="sidebar">
      <div className="sidebar-content">
        <div className="profile">
          <div className="profile-info">
            <FaUser className="profile-icon" />
            <span className="profile-name">Usuario</span>
          </div>
        </div>

        <nav className="nav-links">
          <ul>
            <li onClick={() => handleNavigation('/agendar-cita')}>
              <FaCalendarPlus className="nav-icon" /> 
              Agendar Cita
            </li>
            <li onClick={() => handleNavigation('/consultar-citas')}>
              <div className="icon-container">
                <FaCalendarAlt className="nav-icon" />
                <FaSearch className="nav-icon-secondary" />
              </div>
              Consultar Citas
            </li>
            <li onClick={() => handleNavigation('/historial-medico')}>
              <FaFileAlt className="nav-icon" /> 
              Ver Historial Médico
            </li>
            <li onClick={() => handleNavigation('/servicios')}>
              <FaStore className="nav-icon" /> 
              Ver Servicios
            </li>
            <li onClick={() => handleNavigation('/soporte')}>
              <FaCog className="nav-icon" /> 
              Soporte
            </li>
          </ul>
        </nav>
      </div>

      <div className="logout-container">
        <div className="logout">
          <FiLogOut className="nav-icon" /> Salir
        </div>
      </div>
    </div>
  );
};

export default Sidebar;