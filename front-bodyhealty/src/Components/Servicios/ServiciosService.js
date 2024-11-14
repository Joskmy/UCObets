import axios from 'axios';

const BASE_URL = 'http://localhost:8080/general/api/v1/services';

export const ServiciosService = {
  getServicios: async () => {
    try {
      const response = await axios.get(BASE_URL);
      return response.data.datos;
    } catch (error) {
      throw new Error('Error al obtener servicios');
    }
  },

  createServicio: async (servicio) => {
    try {
      const response = await axios.post(BASE_URL, servicio);
      return response.data;
    } catch (error) {
      throw new Error('Error al crear servicio');
    }
  },

  updateServicio: async (id, servicio) => {
    try {
      const response = await axios.put(`${BASE_URL}/${id}`, servicio);
      return response.data;
    } catch (error) {
      throw new Error('Error al actualizar servicio');
    }
  },

  deleteServicio: async (id) => {
    try {
      if (!id) {
        throw new Error('ID no válido');
      }
      console.log('ID a eliminar:', id); // Para debugging
      const response = await axios.delete(`${BASE_URL}/${id}`);
      if (response.status === 200 || response.status === 204) {
        return true;
      }
      throw new Error(`Error al eliminar: ${response.status}`);
    } catch (error) {
      console.error('Error en deleteServicio:', error);
      if (error.response) {
        console.error('Response data:', error.response.data);
        console.error('Response status:', error.response.status);
      }
      throw error;
    }
  }
}; 