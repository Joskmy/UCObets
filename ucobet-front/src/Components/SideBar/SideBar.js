import React from 'react';
import './SideBar.css';

const Sidebar = () => {
  const handleLinkClick = (e) => {
    e.preventDefault();  
  };
    
  return (
    <div className="sidebar">
      <div className="profile">
        <div className="profile-info">
          <span className="profile-name">Usuario</span>
        </div>
      </div>

      <nav className="nav-links">
        <ul>
          <li><a href="#" onClick={handleLinkClick}>Apostar</a></li>
          <li><a href="#" onClick={handleLinkClick}>Agregar Ciudad</a></li>
          <li><a href="#" onClick={handleLinkClick}>Soporte</a></li>
          <li><a href="/salir">Salir</a></li>
        </ul>
      </nav>
    </div>
  );
};

export default Sidebar;
