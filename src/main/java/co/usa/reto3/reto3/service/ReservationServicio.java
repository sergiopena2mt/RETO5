package co.usa.reto3.reto3.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sergio
 */

/**
 *
 * Imports 
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.reto3.model.Reservation;
import co.usa.reto3.reto3.model.Reports.ContadorClient;
import co.usa.reto3.reto3.model.Reports.StatusReservations;
import co.usa.reto3.reto3.repository.ReservationRepositorio;

/**
 *
 * servicio
 */
@Service
public class ReservationServicio {
    @Autowired
    /**
     *
     * repositorio
     */
    private ReservationRepositorio reservationRepositorio;

    /**
     *
     * Método para obtener todo
     */
    public List<Reservation>getAll(){
        return reservationRepositorio.getAll();
    }


    /**
     *
     * Método para obtener por ID
     */
    public Optional<Reservation>getReservation(int id){
        return reservationRepositorio.getReservation(id);
    }

    /**
     *
     * Método para guardar
     */
    public Reservation save(Reservation rsvt){
        if (rsvt.getIdReservation()==null){
            return reservationRepositorio.save(rsvt);

        }else{
            Optional<Reservation> consulta=reservationRepositorio.getReservation(rsvt.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepositorio.save(rsvt);
            } else {
                return rsvt;
            }
        }
    }

    /**
     *
     * Método para actualizar
     */
    public Reservation update(Reservation rsvt){
        if(rsvt.getIdReservation()!=null){
            Optional<Reservation> consulta=reservationRepositorio.getReservation(rsvt.getIdReservation());
            if(!consulta.isEmpty()){
                if(rsvt.getStartDate()!=null){
                    consulta.get().setStartDate(rsvt.getStartDate());
                }
                if(rsvt.getDevolutionDate()!=null){
                    consulta.get().setDevolutionDate(rsvt.getDevolutionDate());
                }
                if(rsvt.getStatus()!=null){
                    consulta.get().setStatus(rsvt.getStatus());
                }
                if(rsvt.getScore()!=null){
                    consulta.get().setScore(rsvt.getScore());
                }
                return reservationRepositorio.save(consulta.get());
            }
        }
        return rsvt;
    }

    /**
     *
     * Método para borrar
     */
    public boolean deleteReservation(int idReservation){
        Optional<Reservation> consulta=reservationRepositorio.getReservation(idReservation);
            if (!consulta.isEmpty()) {
                reservationRepositorio.delete(consulta.get());
                return true;

            }
        return false;
    }
    /**
     *
     * Método para status
     */

    public StatusReservations reporteStatusServicio (){
        List<Reservation>completed= reservationRepositorio.ReservationStatusRepositorio("completed");
        List<Reservation>cancelled= reservationRepositorio.ReservationStatusRepositorio("cancelled");
        
        return new StatusReservations(completed.size(), cancelled.size() );
    }
    /**
     *
     * Método para  reserva
     */

    public List<Reservation> reportTimeServicio (String fecha1, String fecha2){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fechaIni = new Date();
        Date fechaFin = new Date();
        
        try{
            fechaIni = parser.parse(fecha1);
            fechaFin = parser.parse(fecha2);

        }catch(ParseException evt){
            evt.printStackTrace();

        }if(fechaIni.before(fechaFin)){
            return reservationRepositorio.ReservationTimeRepositorio(fechaIni, fechaFin);
            
        }else{
            return new ArrayList<>();
        
        } 
        /**
     *
     * Método contar cliente
     */
    } 
     public List<ContadorClient> reporteClientServicio(){
            return reservationRepositorio.getClientRepositorio();
        } 
}
