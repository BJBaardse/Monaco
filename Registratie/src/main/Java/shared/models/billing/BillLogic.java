package shared.models.billing;

import shared.models.Kilometertarief;
import shared.models.KilometertariefEnergy;
import shared.models.KilometertariefStreet;
import shared.models.Vehicle;
import shared.models.movements.Imovement;
import shared.models.movements.Irit;
import shared.models.services.KilometertariefService;
import shared.models.services.VehicleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BillLogic {

    private KilometertariefService kilometertariefService;

    private VehicleService vehicleService;



    public BillLogic() {

    }

    private List<Kilometertarief> GetbaseTarief(int ID){

        Vehicle vehicle = vehicleService.GetVehicles(ID);
        List<Kilometertarief> kilometertariefs = new ArrayList<>();
        kilometertariefs.addAll(kilometertariefService.GetEngeryLabel(vehicle.getEnergy()));

        return kilometertariefs;

    }



    private List<Kilometertarief> GetKilometertarief(){
        return kilometertariefService.GetAll();
    }


    private Kilometertarief GetStreets(String street, Date date){

        List<Kilometertarief> kilometertariefs = new ArrayList<Kilometertarief>(kilometertariefService.GetStreet(street));
        return GetLatest(kilometertariefs,date);
    }


    private List<Movement> CalculateRides(Irit rit, int autoID){

        List<Movement> movements = new ArrayList<>();

        List<Kilometertarief> basetariefs = GetbaseTarief(autoID);

        KilometertariefEnergy basetarief = (KilometertariefEnergy) GetLatest(basetariefs, rit.GetDate());


        for(Imovement m : rit.getMovements()){
            Movement movement = new Movement(m.GetStreet(),m.GetDistance(),basetarief);
            movement.setAdditionTarief(GetStreets(m.GetStreet(),m.getDate()));
            movements.add(movement);
        }



        return movements;

    }




    private Kilometertarief GetLatest(List<Kilometertarief> kilometertariefs, Date date){
        Kilometertarief kilometertarief = null;
        //Check latest kilometertarief based on date
        for(Kilometertarief k : kilometertariefs){
            if(k.getStart().after(date) && k.getExpire().before(date)){

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
