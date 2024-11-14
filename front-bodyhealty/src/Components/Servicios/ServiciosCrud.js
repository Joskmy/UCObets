import React, { useState, useEffect } from 'react';
import { ServiciosService } from './ServiciosService';
import ServiciosTable from './ServiciosTable';
import ServicioForm from './ServicioForm';
import './ServiciosCrud.css';

const ServiciosCrud = () => {
  const [servicios, setServicios] = useState([]);
  const [nombre, setNombre] = useState('');
  const [duracion, setDuracion] = useState('');
  const [descripcion, setDescripcion] = useState('');
  const [mensaje, setMensaje] = useState('');
  const [isHiding, setIsHiding] = useState(false);
  const [mostrarFormulario, setMostrarFormulario] = useState(false);
  const [editingId, setEditingId] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchDuration, setSearchDuration] = useState('');
  const [formMode, setFormMode] = useState('register');

  const fetchServicios = async () => {
    try {
      const data = await ServiciosService.getServicios();
      setServicios(data);
    } catch (error) {
      setMensaje('Error al cargar los servicios');
    }
  };

  useEffect(() => {
    fetchServicios();
  }, []);

  useEffect(() => {
    if (mensaje) {
      setIsHiding(false);
      const timer = setTimeout(() => {
        setIsHiding(true);
        setTimeout(() => {
          setMensaje('');
          setIsHiding(false);
        }, 500);
      }, 2000);
      return () => clearTimeout(timer);
    }
  }, [mensaje]);

  const handleEdit = (servicio) => {
    setNombre(servicio.nombreServicio);
    setDuracion(servicio.duracionEstimada.toString());
    setDescripcion(servicio.descripcion);
    setEditingId(servicio.idServicio);
    setFormMode('edit');
    setMostrarFormulario(true);
  };

  const handleNewClick = () => {
    setFormMode('register');
    setMostrarFormulario(true);
  };

  const handleDelete = async (id) => {
    try {
      console.log('Intentando eliminar servicio con ID:', id); // Para debugging
      
      if (!id) {
        setMensaje('Error: ID de servicio no válido');
        return;
      }
  
      const confirmDelete = window.confirm('¿Está seguro de eliminar este servicio?');
      
      if (confirmDelete) {
        const result = await ServiciosService.deleteServicio(id);
        if (result) {
          setMensaje('Servicio eliminado correctamente');
          await fetchServicios(); // Recargar la lista
        } else {
          setMensaje('No se pudo eliminar el servicio');
        }
      }
    } catch (error) {
      console.error('Error completo al eliminar:', error);
      setMensaje(`Error al eliminar el servicio: ${error.message}`);
    }
  };

  const handleSubmit = async () => {
    try {
      if (!nombre || !duracion || !descripcion) {
        setMensaje('Por favor complete todos los campos');
        return;
      }

      const servicioData = {
        nombreServicio: nombre,
        duracionEstimada: parseInt(duracion),
        descripcion: descripcion
      };

      if (editingId) {
        await ServiciosService.updateServicio(editingId, servicioData);
        setMensaje('Servicio actualizado correctamente');
      } else {
        await ServiciosService.createServicio(servicioData);
        setMensaje('Servicio creado correctamente');
      }

      resetForm();
      fetchServicios();
    } catch (error) {
      setMensaje('Error al procesar el servicio');
    }
  };

  const resetForm = () => {
    setNombre('');
    setDuracion('');
    setDescripcion('');
    setEditingId(null);
    setFormMode('register');
    setMostrarFormulario(false);
  };

  return (
    <div className="servicios-crud">
      {mostrarFormulario ? (
        <ServicioForm
          nombre={nombre}
          duracion={duracion}
          descripcion={descripcion}
          setNombre={setNombre}
          setDuracion={setDuracion}
          setDescripcion={setDescripcion}
          handleSubmit={handleSubmit}
          formMode={formMode}
          onCancel={resetForm}
        />
      ) : (
        <div className="table-container">
          <div className="table-header">
            <button 
              onClick={handleNewClick} 
              className="nuevo-button"
            >
              Nuevo
            </button>
            <div className="search-filters">
              <input
                type="text"
                placeholder="Buscar por nombre"
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="search-input"
              />
              <select
                value={searchDuration}
                onChange={(e) => setSearchDuration(e.target.value)}
                className="search-input"
              >
                <option value="">Todas las duraciones</option>
                {Array.from({ length: 20 }, (_, i) => (i + 1) * 15).map(minutos => (
                  <option key={minutos} value={minutos}>
                    {minutos} minutos
                  </option>
                ))}
              </select>
            </div>
          </div>
          
          <ServiciosTable
            servicios={servicios}
            onEdit={handleEdit}
            onDelete={handleDelete}
            searchTerm={searchTerm}
            searchDuration={searchDuration}
          />
        </div>
      )}
      
      {mensaje && (
        <div className={`alert ${mensaje.includes('correctamente') ? 'success' : 'error'} ${isHiding ? 'hiding' : ''}`}>
          {mensaje}
        </div>
      )}
    </div>
  );
};

export default ServiciosCrud;
