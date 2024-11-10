import React from 'react';
import './SideBar.css';

const Sidebar = () => {
  
    
  return (
    <div className="sidebar">
      <div className="profile">
        <div className="profile-info">
          <span className="profile-name">Usuario</span>
        </div>
      </div>

      <nav className="nav-links">
        <ul>
          <li>Apostar</li>
          <li>Agregar Ciudad</li>
          <li>Soporte</li>
          <li>Salir</li>
        </ul>
      </nav>
    </div>
  );
};

export default Sidebar;
