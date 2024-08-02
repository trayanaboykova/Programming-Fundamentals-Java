package Lesson06_GroomingSalon;

public class Main {
    public static void main(String[] args) {
        GroomingSalon salon = new GroomingSalon(5);

        Pet pet1 = new Pet("Bella", 3, "John");
        Pet pet2 = new Pet("Max", 5, "Emma");
        Pet pet3 = new Pet("Luna", 2, "Liam");
        Pet pet4 = new Pet("Charlie", 4, "Olivia");

        salon.add(pet1);
        salon.add(pet2);
        salon.add(pet3);
        salon.add(pet4);

        System.out.println("Number of pets: " + salon.getCount());

        Pet retrievedPet = salon.getPet("Max", "Emma");
        if (retrievedPet != null) {
            System.out.println("Retrieved pet: " + retrievedPet);
        }

        String removed = String.valueOf(salon.remove("Bella"));
        System.out.println("Pet removed: " + removed);

        System.out.println("Number of pets after removal: " + salon.getCount());

        System.out.println(salon.getStatistics());
    }
}
