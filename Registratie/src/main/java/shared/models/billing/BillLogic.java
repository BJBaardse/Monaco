package shared.models.billing;

import shared.models.Kilometertarief;
import shared.models.KilometertariefEnergy;
import shared.models.Vehicle;
import shared.models.enums.Energy;
import shared.models.movements.Imovement;
import shared.models.movements.Irit;
import shared.models.services.KilometertariefService;
import shared.models.services.VehicleService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Stateless
public class BillLogic {
    @Inject
    private KilometertariefService kilometertariefService;
    @Inject
    private VehicleService vehicleService;



    public BillLogic() {

    }

    private List<Kilometertarief> GetbaseTarief(Energy energy){

        List<Kilometertarief> kilometertariefs = new ArrayList<>();
        //kilometertariefs.add((Kilometertarief) kilometertariefService.GetAll());

        List<KilometertariefEnergy> kilometertariefEnergy = kilometertariefService.GetEngeryLabel(energy);
        kilometertariefs.addAll(kilometertariefService.GetEngeryLabel(energy));

        return kilometertariefs;

    }



    private List<Kilometertarief> GetKilometertarief(){
        return kilometertariefService.GetAll();
    }


    private Kilometertarief GetStreets(String street, Date date){

        List<Kilometertarief> kilometertariefs = new ArrayList<Kilometertarief>(kilometertariefService.GetStreet(street));
        return GetLatest(kilometertariefs,date);
    }


    public Bill CalculateBill(List<Irit> rits, Vehicle vehicle){

        List<Ride> rides = new ArrayList<>();
        for(Irit rit : rits){
            rides.add(CalculateRide(rit,vehicle));
        }

        Date time = new Date(System.currentTimeMillis());
        Bill bill = new Bill(time,rides,vehicle,vehicle.getOwner());

        bill.CalcKilometer();
        bill.CalcPrices();
        bill.CalcData();


        return bill;
    }

    // calculateRides with kilometertarief to get a total prices

    private Ride CalculateRide(Irit rit, Vehicle vehicle){

        List<Movement> movements = new ArrayList<>();

        List<Kilometertarief> basetariefs = GetbaseTarief(vehicle.getEnergy());

        KilometertariefEnergy basetarief = (KilometertariefEnergy) GetLatest(basetariefs, rit.GetBeginDateTime());


        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(rit.GetBeginDateTime().getTime());
        //Data from move interface
        for(Imovement m : rit.getMovements()){
            //Convert duration to time Date
            time.setTimeInMillis(time.getTimeInMillis() + m.getDuration().longValue());
            //Convert movement interface to Movement object for billing
            Movement movement = new Movement(m.GetStreetName(),m.GetDistance().intValue(),basetarief);
            movement.setAdditionTarief(GetStreets(m.GetStreetName(),time.getTime()));
            movements.add(movement);
        }

        Ride ride = new Ride(rit.GetBeginDateTime());
        ride.setMovements(movements);
        ride.CalcData();

        return ride;

    }




    private Kilometertarief GetLatest(List<Kilometertarief> kilometertariefs, Date date){
        Kilometertarief kilometertarief = null;
        //Check latest kilometertarief based on date
        for(Kilometertarief k : kilometertariefs){

            boolean b = k.getStart().after(date);
            if(k.getStart().before(date) && k.getExpire().after(date)){

                //Check between old select kilometertarief
                if( kilometertarief != null){
                    int compare = kilometertarief.getStart().compareTo(k.getStart());
                    if(compare > 0){
                        // Keep old value kilometertarief is the new value

                    } else if (compare < 0){
                        // Set new value k is the new value
                        kilometertarief = k;
                    }
                    else if (compare == 0){
                        int compare2 = kilometertarief.getExpire().compareTo(k.getExpire());
                        if(compare > 0){
                            // Keep old value kilometertarief is the new value

                        } else if (compare < 0){
                            // Set new value k is the new value
                            kilometertarief = k;
                        }
                    }
                } else {
                    kilometertarief = k;
                }
            }
        }

        return kilometertarief;
    }

}