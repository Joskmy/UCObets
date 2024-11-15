import axios from 'axios';

const BASE_URL = 'https://localhost:8443/general/api/v1/services';

export const ServiciosService = {
  getServicios: async () => {
    try {
      const response = await axios.get(BASE_URL);
      return response.data.datos;
    } catch (error) {
      const errorMessage = error.response?.data?.mensajes?.[0] || 'Error al obtener servicios';
      throw new Error(errorMessage);
    }
  },

  createServicio: async (servicio) => {
    try {
      const response = await axios.post(BASE_URL, servicio);
      return response.data.mensajes[0];  // Devuelve el mensaje de la respuesta de la API
    } catch (error) {
      const errorMessage = error.response?.data?.mensajes?.[0] || 'Error al crear servicio';
      throw new Error(errorMessage);
    }
  },

  updateServicio: async (id, servicio) => {
    try {
      const response = await axios.put(`${BASE_URL}/${id}`, servicio);
      return response.data.mensajes[0];
    } catch (error) {
      const errorMessage = error.response?.data?.mensajes?.[0] || 'Error al actualizar servicio';
      throw new Error(errorMessage);
    }
  },

  deleteServicio: async (id) => {
    try {
      const response = await axios.delete(`${BASE_URL}/${id}`);
      return response.data.mensajes[0];
    } catch (error) {
      const errorMessage = error.response?.data?.mensajes?.[0] || 'Error al eliminar servicio';
      throw new Error(errorMessage);
    }
  }
};
