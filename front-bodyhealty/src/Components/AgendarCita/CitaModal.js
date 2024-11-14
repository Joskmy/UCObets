import React from 'react';
import { 
  DialogTitle, 
  DialogContent, 
  DialogActions,
  Button,
  TextField,
  Select,
  MenuItem,
  FormControl,
  InputLabel,
  Box
} from '@mui/material';
import { format } from 'date-fns';
import './CitaModal.css';

const CitaModal = ({ date, onClose, onSave }) => {
  const [formData, setFormData] = React.useState({
    paciente: 'Jose Miguel Posada',
    servicio: '',
    especialista: '',
    consultorio: '',
    fecha: date ? format(date, 'yyyy-MM-dd') : '',
    turno: ''
  });

  const especialistas = ['Especialista 1', 'Especialista 2', 'Especialista 3'];
  const consultorios = ['Consultorio 1', 'Consultorio 2', 'Consultorio 3'];
  const turnos = ['08:00', '10:00', '12:00', '14:00', '16:00'];
  const servicios = ['Servicio 1', 'Servicio 2', 'Servicio 3'];

  const handleSubmit = () => {
    const { servicio, fecha, turno } = formData;
    if (servicio && fecha && turno) {
      onSave({
        title: servicio,
        start: `${fecha}T${turno}`
      });
    }
  };

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  return (
    <Box className="cita-modal">
      <DialogTitle>Formulario de Cita</DialogTitle>
      <DialogContent>
        <Box className="form-container">
          <TextField
            margin="dense"
            label="Paciente"
            value={formData.paciente}
            disabled
            fullWidth
          />

          <FormControl fullWidth margin="dense">
            <InputLabel>Servicio</InputLabel>
            <Select
              name="servicio"
              value={formData.servicio}
              onChange={handleChange}
            >
              {servicios.map((servicio) => (
                <MenuItem key={servicio} value={servicio}>
                  {servicio}
                </MenuItem>
              ))}
            </Select>
          </FormControl>

          <FormControl fullWidth margin="dense">
            <InputLabel>Especialista</InputLabel>
            <Select
              name="especialista"
              value={formData.especialista}
              onChange={handleChange}
            >
              {especialistas.map((especialista) => (
                <MenuItem key={especialista} value={especialista}>
                  {especialista}
                </MenuItem>
              ))}
            </Select>
          </FormControl>

          <FormControl fullWidth margin="dense">
            <InputLabel>Consultorio</InputLabel>
            <Select
              name="consultorio"
              value={formData.consultorio}
              onChange={handleChange}
            >
              {consultorios.map((consultorio) => (
                <MenuItem key={consultorio} value={consultorio}>
                  {consultorio}
                </MenuItem>
              ))}
            </Select>
          </FormControl>

          <TextField
            margin="dense"
            label="Fecha"
            type="date"
            name="fecha"
            value={formData.fecha}
            onChange={handleChange}
            fullWidth
            InputLabelProps={{
              shrink: true,
            }}
          />

          <FormControl fullWidth margin="dense">
            <InputLabel>Turno</InputLabel>
            <Select
              name="turno"
              value={formData.turno}
              onChange={handleChange}
            >
              {turnos.map((turno) => (
                <MenuItem key={turno} value={turno}>
                  {turno}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Box>
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose} color="error">
          Cerrar
        </Button>
        <Button onClick={handleSubmit} color="primary" variant="contained">
          Guardar
        </Button>
      </DialogActions>
    </Box>
  );
};

export default CitaModal;