package Lesson06_ObjectsAndClasses.MoreExercises.P03_CarSalesman;

public class Engine {
    private String model;//required
    private int power;//required
    private int displacement;//optional
    private String efficiency;//optional


    public Engine() {

    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
