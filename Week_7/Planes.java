abstract class Plane{
    private final int planeId;
    private static int idCounter = 1;
    private final int enginePower;

    public Plane(int enginePower){
        this.enginePower = enginePower;
        this.planeId = idCounter;
        idCounter++;
    }

    public String getPlaneID(){
        return String.valueOf(this.planeId);
        //return "" + this.planeId;  //Asta e echivalent cu ce e mai sus
    }

    public int getTotalEnginePower(){
        return this.enginePower;
    }

    public void takeOff(){
        System.out.println("Plane: " + this.getPlaneID() + ": takeOff");
    }

    public void land(){
        System.out.println("Plane: " + this.getPlaneID() + ": land");
    }

    public void fly(){
        System.out.println("Plane: " + this.getPlaneID() + ": fly");
    }
}

abstract class PassengersPlane extends Plane{
    private int maxPassengers;

    public PassengersPlane(int maxPassengers, int enginePower){
        super(enginePower);
        this.maxPassengers = maxPassengers;
    }
    public int getMaxPassengers(){
        return this.maxPassengers;
    }

}

class Boeing extends PassengersPlane{
    public Boeing(int maxPassengers, int powerEngine){
        super(maxPassengers, powerEngine);
    }
    
    @Override
    public String toString(){
        return "Boeing Plane with ID: " + this.getPlaneID() + " with max passengers: "+ this.getMaxPassengers() + " with power: " + this.getTotalEnginePower();
    }
}

class Concorde extends PassengersPlane{

    // public Concorde(){
    //     super(500,1200);                           ////Facem asta ca pentru a atribui default niste valori
    // }

    public Concorde(int maxPassengers, int powerEngine){              //Asta facem ca sa putem atribui noi valori in main
        super(maxPassengers, powerEngine);
    }

    public void goSuperSonic(){
        System.out.println("Concorde with ID: " + this.getPlaneID() + " Supersonic Mode Activated");
    }

    public void goSubSonic(){
        System.out.println("Concorde with ID: " + this.getPlaneID() + " Supersonic Mode Deactivated");
    }

    
    @Override
    public String toString(){
        return "Concorde Plane with ID: " + this.getPlaneID()+ " with max passengers: "+ this.getMaxPassengers() + " with power: " + this.getTotalEnginePower();
    }
}

abstract class FighterPlane extends Plane{
    public FighterPlane(int powerEngine){
        super(powerEngine);
    }
    public void launchMissile(){
        System.out.println("Fighter Plane with ID: " + this.getPlaneID() + " Launching rocket");
    }
}

class MIG extends FighterPlane{
    public MIG(int powerEngine){
        super(powerEngine);
    }  
    public void highSpeedGeometry(){
        System.out.println("MIG with ID: " + this.getPlaneID() + " High Speed selected geometry");
    }

    public void normalGeometry(){
        System.out.println("MIG with ID: " + this.getPlaneID() + " Normal Speed selected geometry");
    }

    
    @Override
    public String toString(){
        return "MIG Plane with ID: " + this.getPlaneID() + " with power: " + this.getTotalEnginePower();
    }
}

class TomCat extends FighterPlane{
    public TomCat(int powerEngine){
        super(powerEngine);
    }

    public void refuel(){
        System.out.println("TomCat with ID: " + this.getPlaneID() + " Refueling");
    }

    
    @Override
    public String toString(){
        return "TomCat Plane with ID: " + this.getPlaneID() + " with power: " + this.getTotalEnginePower();
    }
}

class Fleet{
    private static int fleetSize = 100;
    private int currentpassengersPlanes = 0;
    private int currentfighterPlanes = 0;

    PassengersPlane[] passengersPlanes = new PassengersPlane[fleetSize];
    FighterPlane[] fighterPlanes = new FighterPlane[fleetSize];

    public void addPlane(Plane plane){
        if(plane instanceof PassengersPlane){
            if(currentpassengersPlanes < fleetSize){
                passengersPlanes[currentpassengersPlanes] = (PassengersPlane) plane;
                currentpassengersPlanes++;
            }
            else{
                System.out.println("Passenger Fleet is full");
            }
        } else if(plane instanceof FighterPlane){
            if(currentfighterPlanes < fleetSize){
                fighterPlanes[currentfighterPlanes] = (FighterPlane) plane;
                currentfighterPlanes++;
            }
            else{
                System.out.println("Fighter Fleet is full");
            }
        }
    }

    public FighterPlane getFighterPlane(int index){
        if(fighterPlanes[index] == null){
            return null;
        }
        return fighterPlanes[index];
    }

    public Plane getStrongestPlane(){
        int maxPower = 0;
        Plane strongestPlane = null;
        for(int i = 0; i < currentpassengersPlanes; i++){
            if(passengersPlanes[i].getTotalEnginePower() > maxPower){
                maxPower = passengersPlanes[i].getTotalEnginePower();
                strongestPlane = passengersPlanes[i];
            }
        }
        for(int i = 0; i < currentfighterPlanes; i++){
            if(fighterPlanes[i].getTotalEnginePower() > maxPower){
                maxPower = fighterPlanes[i].getTotalEnginePower();
                strongestPlane = fighterPlanes[i];
            }
        }
        return strongestPlane;
    }

    public int getTotalPassengerCapacity(){
        int totalPassengerCapacity = 0;
        for(int i = 0; i < currentpassengersPlanes; i++){
            totalPassengerCapacity += passengersPlanes[i].getMaxPassengers();
        }
        return totalPassengerCapacity;
    }

    public void getAnyPlane(int id){
        Plane[] allPlanes = new Plane[currentpassengersPlanes + currentfighterPlanes];
        System.arraycopy(passengersPlanes, 0, allPlanes, 0, currentpassengersPlanes);
        System.arraycopy(fighterPlanes, 0, allPlanes, currentpassengersPlanes, currentfighterPlanes);
        System.out.println(allPlanes[id-1]);
    }
}

class FleetManagement {
    public static void main(String[] args) {
        // Instantiate planes using type inheritance
        Plane concorde1 = new Concorde(5000, 100);
        Plane boeing1 = new Boeing(4000, 200);
        Plane mig1 = new MIG(6000);
        Plane tomcat1 = new TomCat(7000);

        // Uncommenting the following lines should cause compilation errors
        // because abstract classes cannot be instantiated
        //  Plane plane = new Plane(3000);
        //  PassengersPlane passengerPlane = new PassengersPlane(3500, 150);
        //  FighterPlane fighterPlane = new FighterPlane(4000);

        // Create Fleet
        Fleet fleet = new Fleet();

        // Add planes to fleet
        fleet.addPlane(concorde1);
        fleet.addPlane(boeing1);
        fleet.addPlane(mig1);
        fleet.addPlane(tomcat1);

        // Add more planes to fleet using type inheritance
        Plane concorde2 = new Concorde(110, 5500);
        Plane boeing2 = new Boeing(180, 4200);
        Plane mig2 = new MIG(6200);
        Plane tomcat2 = new TomCat(7100);

        fleet.addPlane(concorde2);
        fleet.addPlane(boeing2);
        fleet.addPlane(mig2);
        fleet.addPlane(tomcat2);

        // Demonstrate fleet functionalities

        // Retrieve and display the plane with the highest engine power
        Plane strongestPlane = fleet.getStrongestPlane();
        if (strongestPlane != null) {
            System.out.println("Strongest Plane ID: " + strongestPlane.getPlaneID() +
                    ", Engine Power: " + strongestPlane.getTotalEnginePower());
            if(strongestPlane instanceof PassengersPlane) {
                System.out.println("Strongest plane is a passanger plane");
            } else if(strongestPlane instanceof FighterPlane) {
                System.out.println("Strongest plane is a fighter plane");
            }
            strongestPlane.takeOff();
            strongestPlane.fly();
            strongestPlane.land();
        }

         // Calculate and display the total passenger capacity of the fleet
        int totalCapacity = fleet.getTotalPassengerCapacity();
        System.out.println("Total Passenger Capacity of the Fleet: " + totalCapacity);


        // Retrieve fighter planes from the fleet and demonstrate their functionalities
        for(int i=0; i < 6; i++) {
            FighterPlane fighterPlane = fleet.getFighterPlane(i);
            if (fighterPlane != null) {
                fighterPlane.takeOff();
                fighterPlane.fly();
                fighterPlane.launchMissile();
                if (fighterPlane instanceof MIG) {
                    ((MIG) fighterPlane).highSpeedGeometry();
                } else if (fighterPlane instanceof TomCat) {
                    ((TomCat) fighterPlane).refuel();
                }
                fighterPlane.land();
            } else {
                System.out.println("No fighter plane at index " + i);
            }
        }

    }
}
