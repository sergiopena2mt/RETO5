package co.usa.reto3.reto3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.reto3.model.Reservation;
import co.usa.reto3.reto3.model.Client;
import co.usa.reto3.reto3.model.Reports.ContadorClient;
import co.usa.reto3.reto3.repository.crud.ReservationCrudRepositorio;

@Repository
public class ReservationRepositorio {
    @Autowired
    private ReservationCrudRepositorio reservationCrudRepositorio;


    public List<Reservation>getAll(){
        return (List<Reservation>)reservationCrudRepositorio.findAll();
    }

    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepositorio.findById(id);
    }

    public Reservation save(Reservation rsvt){
        return reservationCrudRepositorio.save(rsvt);
    }
    public void delete(Reservation rsvt){
        reservationCrudRepositorio.delete(rsvt);
    }


    public List<Reservation> ReservationStatusRepositorio (String status){
        return reservationCrudRepositorio.findAllByStatus(status);
    }
    
    public List<Reservation> ReservationTimeRepositorio (Date fechaIni, Date fechaFin){
        return reservationCrudRepositorio.findAllByStartDateAfterAndStartDateBefore(fechaIni, fechaFin);
    
    }
    
    public List<ContadorClient> getClientRepositorio(){
        List<ContadorClient> rsvt = new ArrayList<>();
        List<Object[]> report = reservationCrudRepositorio.countTotalReservacionesByClient();
        for(int i=0; i<report.size(); i++){
            rsvt.add(new ContadorClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return rsvt;    
    }
}
