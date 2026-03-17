public class BookMyStayApp {
    public static void main(String[] args){

        // Version 3.1

import java.util.HashMap;
import java.util.Map;

// Abstract Room class (same as previous use case)
        abstract class Room {
            private int beds;
            private double size;
            private double price;

            public Room(int beds, double size, double price) {
                this.beds = beds;
                this.size = size;
                this.price = price;
            }

            public int getBeds() {
                return beds;
            }

            public double getSize() {
                return size;
            }

            public double getPrice() {
                return price;
            }

            public abstract String getRoomType();

            public void displayRoomDetails() {
                System.out.println("Room Type: " + getRoomType());
                System.out.println("Beds: " + beds);
                System.out.println("Size: " + size + " sq.ft");
                System.out.println("Price: ₹" + price);
            }
        }

// Concrete Room Classes
        class SingleRoom extends Room {
            public SingleRoom() {
                super(1, 120.0, 2000.0);
            }

            public String getRoomType() {
                return "Single";
            }
        }

        class DoubleRoom extends Room {
            public DoubleRoom() {
                super(2, 200.0, 3500.0);
            }

            public String getRoomType() {
                return "Double";
            }
        }

        class SuiteRoom extends Room {
            public SuiteRoom() {
                super(3, 350.0, 6000.0);
            }

            public String getRoomType() {
                return "Suite";
            }
        }

// RoomInventory Class (NEW)
        class RoomInventory {

            private HashMap<String, Integer> inventory;

            // Constructor → initialize inventory
            public RoomInventory() {
                inventory = new HashMap<>();

                // Initial room availability
                inventory.put("Single", 10);
                inventory.put("Double", 5);
                inventory.put("Suite", 2);
            }

            // Get availability
            public int getAvailability(String roomType) {
                return inventory.getOrDefault(roomType, 0);
            }

            // Update availability (controlled)
            public void updateAvailability(String roomType, int count) {
                if (inventory.containsKey(roomType)) {
                    inventory.put(roomType, count);
                } else {
                    System.out.println("Room type not found!");
                }
            }

            // Display all inventory
            public void displayInventory() {
                System.out.println("\n=== CURRENT ROOM INVENTORY ===");
                for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                    System.out.println(entry.getKey() + " Rooms Available: " + entry.getValue());
                }
            }
        }

// Main Class
        public class UseCase3InventorySetup {

            public static void main(String[] args) {

                // Create room objects
                Room single = new SingleRoom();
                Room doubleRoom = new DoubleRoom();
                Room suite = new SuiteRoom();

                // Initialize inventory
                RoomInventory inventory = new RoomInventory();

                System.out.println("=== HOTEL ROOM DETAILS ===\n");

                single.displayRoomDetails();
                System.out.println("Available: " + inventory.getAvailability(single.getRoomType()));
                System.out.println("----------------------------");

                doubleRoom.displayRoomDetails();
                System.out.println("Available: " + inventory.getAvailability(doubleRoom.getRoomType()));
                System.out.println("----------------------------");

                suite.displayRoomDetails();
                System.out.println("Available: " + inventory.getAvailability(suite.getRoomType()));
                System.out.println("----------------------------");

                // Show full inventory
                inventory.displayInventory();

                // Update example
                System.out.println("\nUpdating Suite availability to 1...\n");
                inventory.updateAvailability("Suite", 1);

                inventory.displayInventory();
            }
        }

    }
}
