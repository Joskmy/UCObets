import axios from 'axios';

const BASE_URL = 'https://7ga2e9l7b7.execute-api.us-east-1.amazonaws.com/pruebapost/general/api/v1/services';

export const ServiciosService = {
  getServicios: async () => {
    try {
      const response = await axios.get(BASE_URL, {
        headers: {
          'Content-Type': 'application/json',
          'ngrok-skip-browser-warning': 'true'
        }
      });
      
      if (typeof response.data === 'string' && response.data.includes('<!DOCTYPE html>')) {
        throw new Error('Error de conexión con el servidor');
      }

      console.log('Respuesta completa:', response.data);
      
      // Verificar si la respuesta tiene la estructura esperada
      if (response.data && Array.isArray(response.data.datos)) {
        return response.data.datos;
      } else {
        console.error('Formato de respuesta inválido:', response.data);
        throw new Error('Formato de respuesta inválido');
      }
    } catch (error) {
      console.error('Error en getServicios:', error);
      throw new Error(error.message || 'Error al obtener servicios');
    }
  },

  createServicio: async (servicio) => {
    try {
      const response = await axios.post(BASE_URL, servicio, {
        headers: {
          'Content-Type': 'application/json',
          'ngrok-skip-browser-warning': 'true'
        }
      });
      
      // Validar la estructura de la respuesta
      if (!response.data?.mensajes?.[0] || !response.data?.datos?.[0]) {
        throw new Error('Respuesta inválida del servidor');
      }

      return {
        mensaje: response.data.mensajes[0],
        servicio: response.data.datos[0]
      };
    } catch (error) {
      console.error('Error al crear servicio:', error);
      throw new Error(error.response?.data?.mensajes?.[0] || 'Error al crear servicio');
    }
  },

  updateServicio: async (id, servicio) => {
    try {
      const response = await axios.put(`${BASE_URL}/${id}`, servicio, {
        headers: {
          'Content-Type': 'application/json',
          'ngrok-skip-browser-warning': 'true'
        }
      });
      
      if (response.data && response.data.mensajes && response.data.datos) {
        return {
          mensaje: response.data.mensajes[0],
          servicio: response.data.datos[0]
        };
      }
      throw new Error('Formato de respuesta inválido');
    } catch (error) {
      throw new Error(error.response?.data?.mensajes?.[0] || 'Error al actualizar servicio');
    }
  },

  deleteServicio: async (id) => {
    try {
      const response = await axios.delete(`${BASE_URL}/${id}`, {
        headers: {
          'Content-Type': 'application/json',
          'ngrok-skip-browser-warning': 'true'
        }
      });
      return response.data.mensajes[0];
    } catch (error) {
      throw new Error(error.response?.data?.mensajes?.[0] || 'Error al eliminar servicio');
    }
  }
};
