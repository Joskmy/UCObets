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
  const [id, setId] = useState('');

  const fetchServicios = async () => {
    try {
      const data = await ServiciosService.getServicios();
      console.log('Datos recibidos en fetchServicios:', data);
      if (Array.isArray(data)) {
        setServicios(data);
      } else {
        console.error('Los datos recibidos no son un array:', data);
        setServicios([]);
      }
    } catch (error) {
      console.error('Error en fetchServicios:', error);
      setMensaje(error.message);
      setServicios([]);
    }
  };

  useEffect(() => {
    const inicializarDatos = async () => {
      try {
        console.log('Iniciando carga de servicios...');
        const data = await ServiciosService.getServicios();
        console.log('Datos recibidos en inicializarDatos:', data);
        
        if (!data || data.length === 0) {
          console.log('No se recibieron datos');
          setMensaje('No hay servicios disponibles');
        } else {
          console.log('Actualizando estado con datos:', data);
          setServicios(data);
        }
      } catch (error) {
        console.error('Error al inicializar datos:', error);
        setMensaje('Error al cargar los servicios: ' + error.message);
      }
    };

    inicializarDatos();
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
    setEditingId(servicio.id);
    setFormMode('edit');
    setMostrarFormulario(true);
  };

  const handleNewClick = () => {
    setFormMode('register');
    setMostrarFormulario(true);
  };

  const handleDelete = async (id) => {
    try {
      if (!id) {
        setMensaje('Error: ID de servicio no válido');
        return;
      }

      const confirmDelete = window.confirm('¿Está seguro de eliminar este servicio?');
      if (confirmDelete) {
        const responseMessage = await ServiciosService.deleteServicio(id);
        setMensaje(responseMessage);
        await fetchServicios();
      }
    } catch (error) {
      setMensaje(error.message);
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

      let response;
      if (editingId) {
        // Si hay un editingId, actualizamos
        response = await ServiciosService.updateServicio(editingId, servicioData);
      } else {
        // Si no hay editingId, creamos nuevo con el ID ingresado
        if (!id) {
          setMensaje('Por favor ingrese el ID del servicio');
          return;
        }
        servicioData.id = id;
        response = await ServiciosService.createServicio(servicioData);
      }

      setMensaje(response.mensaje);
      resetForm();
      await fetchServicios();
    } catch (error) {
      setMensaje(error.message);
    }
  };

  const resetForm = () => {
    setId('');
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
          id={id}
          setId={setId}
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
            <button onClick={handleNewClick} className="nuevo-button">
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
                {Array.from({ length: 20 }, (_, i) => (i + 1) * 15).map((minutos) => (
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
  <div className={`alert ${
    mensaje.includes('correctamente') || 
    mensaje.includes('éxito') || 
    mensaje.includes('Se ha modificado') ||
    mensaje.includes('Se ha eliminado')
      ? 'success' 
      : 'error'
  } ${isHiding ? 'hiding' : ''}`}>
    {mensaje}
  </div>
)}
    </div>
  );
};

export default ServiciosCrud;
