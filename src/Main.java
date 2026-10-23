// Main class
// This class creates GameServer objects and uses them.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // create 2 objects
        GameServer server1 = new GameServer();                                   // default constructor
        GameServer server2 = new GameServer("Ran-Asia", "203.106.12.40", 5001, "Asia", 100); // parameterized constructor

        // use setter to change server1
        server1.setServerName("Ran-Europe");
        server1.setIpAddress("51.68.200.10");
        server1.setRegion("Europe");
        server1.setPort(70000);   // wrong port, will be rejected
        server1.setPort(5002);    // correct port

        // use getter to show server1 values
        System.out.println("Server 1 name: " + server1.getServerName());
        System.out.println("Server 1 port: " + server1.getPort());

        // turn on both servers
        server1.setOnline(true);
        server2.setOnline(true);

        // for loop - 25 players join server2 every hour for 5 hours
        System.out.println();
        System.out.println("Players joining " + server2.getServerName());
        for (int hour = 1; hour <= 5; hour++) {
            System.out.print("Hour " + hour + ": ");
            server2.addPlayers(25);
        }

        // if else - check how busy server2 is
        if (server2.getLoad() >= 100) {
            System.out.println("Server 2 status: FULL");
        } else if (server2.getLoad() >= 70) {
            System.out.println("Server 2 status: BUSY");
        } else {
            System.out.println("Server 2 status: NORMAL");
        }

        // while loop + switch - menu for server1
        int choice = 0;

        while (choice != 4) {
            System.out.println();
            System.out.println("===== MENU =====");
            System.out.println("1. Show server info");
            System.out.println("2. Add players");
            System.out.println("3. Remove players");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    server1.displayInfo();
                    break;
                case 2:
                    System.out.print("How many players join? ");
                    int join = input.nextInt();
                    server1.addPlayers(join);
                    break;
                case 3:
                    System.out.print("How many players leave? ");
                    int leave = input.nextInt();
                    server1.removePlayers(leave);
                    break;
                case 4:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Wrong choice!");
            }
        }
    }
}
