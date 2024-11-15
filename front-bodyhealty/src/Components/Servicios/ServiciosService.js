import axios from 'axios';

const BASE_URL = 'https://localhost:8443/general/api/v1/services';

const axiosInstance = axios.create({
  baseURL: BASE_URL,
  auth: { 
    username: 'user', 
    password: '123456' 
  },
  headers: {
    'Content-Type': 'application/json'
  },
  // Configuración para ignorar certificados SSL en desarrollo
  validateStatus: function (status) {
    return status >= 200 && status < 500;
  }
});

export const ServiciosService = {
  getServicios: async () => {
    try {
      const response = await axiosInstance.get('/', {
        // Configuración específica para esta petición si es necesaria
      });
      console.log('Respuesta completa:', response);
      return response.data.datos;
    } catch (error) {
      console.error('Error en getServicios:', error);
      throw error;
    }
  },

  createServicio: async (servicio) => {
    try {
      const response = await axiosInstance.post('/', servicio);
      return response.data;
    } catch (error) {
      console.error('Error en createServicio:', error);
      throw error;
    }
  }
};
