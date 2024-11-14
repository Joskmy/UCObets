import React from 'react';
import FullCalendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { Dialog } from '@mui/material';
import CitaModal from './CitaModal';
import './AgendarCita.css';

const AgendarCita = () => {
  const [open, setOpen] = React.useState(false);
  const [selectedDate, setSelectedDate] = React.useState(null);
  const calendarRef = React.useRef(null);

  const handleDateClick = (arg) => {
    setSelectedDate(arg.date);
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleSave = (eventData) => {
    if (calendarRef.current) {
      const calendarApi = calendarRef.current.getApi();
      calendarApi.addEvent(eventData);
    }
    setOpen(false);
  };

  return (
    <div className="agendar-cita">
      <h2>Agendar Nueva Cita</h2>
      <div className="calendar-container">
        <FullCalendar
          ref={calendarRef}
          plugins={[dayGridPlugin, interactionPlugin]}
          initialView="dayGridMonth"
          dateClick={handleDateClick}
          events={[
            {
              title: 'Servicio prueba',
              start: '2024-05-24'
            }
          ]}
          displayEventTime={false}
        />
      </div>

      <Dialog open={open} onClose={handleClose}>
        <CitaModal 
          date={selectedDate} 
          onClose={handleClose}
          onSave={handleSave}
        />
      </Dialog>
    </div>
  );
};

export default AgendarCita;