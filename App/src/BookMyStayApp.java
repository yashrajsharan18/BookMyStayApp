public class BookMyStayApp {
    public static void main(String[] args){

        // Version 2.1

        abstract class Room {
            private int beds;
            private double size;
            private double price;

            // Constructor
            public Room(int beds, double size, double price) {
                this.beds = beds;
                this.size = size;
                this.price = price;
            }

            // Getters
            public int getBeds() {
                return beds;
            }

            public double getSize() {
                return size;
            }

            public double getPrice() {
                return price;
            }

            // Abstract method
            public abstract String getRoomType();

            // Display method
            public void displayRoomDetails() {
                System.out.println("Room Type: " + getRoomType());
                System.out.println("Beds: " + beds);
                System.out.println("Size: " + size + " sq.ft");
                System.out.println("Price: ₹" + price);
            }
        }

// Single Room Class
        class SingleRoom extends Room {
            public SingleRoom() {
                super(1, 120.0, 2000.0);
            }

            @Override
            public String getRoomType() {
                return "Single Room";
            }
        }

// Double Room Class
        class DoubleRoom extends Room {
            public DoubleRoom() {
                super(2, 200.0, 3500.0);
            }

            @Override
            public String getRoomType() {
                return "Double Room";
            }
        }

// Suite Room Class
        class SuiteRoom extends Room {
            public SuiteRoom() {
                super(3, 350.0, 6000.0);
            }

            @Override
            public String getRoomType() {
                return "Suite Room";
            }
        }

// Main Class
        public class UseCase2RoomInitialization {

            public static void main(String[] args) {

                // Create room objects (Polymorphism)
                Room single = new SingleRoom();
                Room doubleRoom = new DoubleRoom();
                Room suite = new SuiteRoom();

                // Static availability variables
                int singleAvailable = 10;
                int doubleAvailable = 5;
                int suiteAvailable = 2;

                // Display details
                System.out.println("=== HOTEL ROOM AVAILABILITY ===\n");

                single.displayRoomDetails();
                System.out.println("Available: " + singleAvailable);
                System.out.println("----------------------------");

                doubleRoom.displayRoomDetails();
                System.out.println("Available: " + doubleAvailable);
                System.out.println("----------------------------");

                suite.displayRoomDetails();
                System.out.println("Available: " + suiteAvailable);
                System.out.println("----------------------------");
            }
        }


    }
}
