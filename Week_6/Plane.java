class Plane{
    private final int planeId;
    private static int idCounter = 1;
    private final int enginePower;

    public Plane(int enginePower){
        this.enginePower = enginePower;
        this.planeId = idCounter++;
    }

    public String getPlaneID(){
        return String.valueOf(this.planeId);
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

class Boeing extends Plane{
    private final int maxPassengers;
    public Boeing(int maxPassengers, int powerEngine){
        super(powerEngine);
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers(){
        return this.maxPassengers;
    }
}

class Concorde extends Boeing{
    public Concorde(int maxPassengers, int powerEngine){
        super(maxPassengers, powerEngine);
    }

    public void goSuperSonic(){
        System.out.println("Concorde " + this.getPlaneID() + " Supersonic Mode Activated");
    }

    public void goSubSonic(){
        System.out.println("Concorde " + this.getPlaneID() + " Supersonic Mode Deactivated");
    }
}

class FighterPlane extends Plane{
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

class FleetManagement {
    public static void main(String[] args) {

        Plane[] fleet = new Plane[8];

        fleet[0] = new Concorde(3000, 100);
        fleet[1] = new Concorde(3200, 120);
        fleet[2] = new MIG(2500);
        fleet[3] = new MIG(2600);
        fleet[4] = new TomCat(2800);
        fleet[5] = new TomCat(2900);
        fleet[6] = new Boeing(28000, 300);
        fleet[7] = new Boeing(29000, 320);

        
        for (Plane plane : fleet) {
            plane.takeOff();
            plane.fly();
            plane.land();

            
            if (plane instanceof Concorde) {
                ((Concorde) plane).goSuperSonic();
                ((Concorde) plane).goSubSonic();
                System.out.println("Max Passengers: " + ((Concorde) plane).getMaxPassengers());
            } else if (plane instanceof Boeing){
                System.out.println("Max Passengers: " + ((Boeing) plane).getMaxPassengers());
            } else if (plane instanceof MIG) {
                ((MIG) plane).highSpeedGeometry();
                ((MIG) plane).normalGeometry();
                ((FighterPlane) plane).launchMissile();
            } else if (plane instanceof TomCat) {
                ((TomCat) plane).refuel();
                ((FighterPlane) plane).launchMissile();
            }

            System.out.println("Total Engine Power: " + plane.getTotalEnginePower());
        }
    }
}
