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
}

class Concorde extends PassengersPlane{

    // public Concorde(){
    //     super(500,1200);                           ////Facem asta ca pentru a atribui default niste valori
    // }

    public Concorde(int maxPassengers, int powerEngine){              //Asta facem ca sa putem atribui noi valori in main
        super(maxPassengers, powerEngine);
    }

    public void goSuperSonic(){
        System.out.println("Concorde " + this.getPlaneID() + " Supersonic Mode Activated");
    }

    public void goSubSonic(){
        System.out.println("Concorde " + this.getPlaneID() + " Supersonic Mode Deactivated");
    }
}

abstract class FighterPlane extends Plane{
    public FighterPlane(int powerEngine){
        super(powerEngine);
    }
    public void launchMissile(){
        System.out.println("Fighter Plane " + this.getPlaneID() + " Launching rocket");
    }
}

class MIG extends FighterPlane{
    public MIG(int powerEngine){
        super(powerEngine);
    }  
    public void highSpeedGeometry(){
        System.out.println("MIG " + this.getPlaneID() + " High Speed selected geometry");
    }

    public void normalGeometry(){
        System.out.println("MIG " + this.getPlaneID() + " Normal Speed selected geometry");
    }
}

class TomCat extends FighterPlane{
    public TomCat(int powerEngine){
        super(powerEngine);
    }

    public void refuel(){
        System.out.println("TomCat " + this.getPlaneID() + " Refueling");
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

    public FighterPlane getgFighterPlane(int index){
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
}

class FleetManagement {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();

        Boeing boeing1 = new Boeing(300, 1000);
        Boeing boeing2 = new Boeing(350, 1100);
        Concorde concorde1 = new Concorde(100, 1500);
        MIG mig1 = new MIG(2000);
        TomCat tomcat1 = new TomCat(1800);

        fleet.addPlane(boeing1);
        fleet.addPlane(boeing2);
        fleet.addPlane(concorde1);
        fleet.addPlane(mig1);
        fleet.addPlane(tomcat1);

        System.out.println("Total Passenger Capacity: " + fleet.getTotalPassengerCapacity());

        Plane strongestPlane = fleet.getStrongestPlane();
        if (strongestPlane != null) {
            System.out.println("Strongest Plane ID: " + strongestPlane.getPlaneID() + " with power: " + strongestPlane.getTotalEnginePower());
        }

        concorde1.goSuperSonic();
        concorde1.goSubSonic();
        mig1.launchMissile();
        mig1.highSpeedGeometry();
        mig1.normalGeometry();
        tomcat1.refuel();
    }
}
