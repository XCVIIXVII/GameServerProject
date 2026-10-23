// GameServer class
// This class is about an online game server.
// All attributes are private (encapsulation).
// Other classes must use get and set methods to use them.

public class GameServer {

    // Attributes (7)
    private String serverName;
    private String ipAddress;
    private int port;
    private String region;
    private int maxPlayers;
    private int currentPlayers;
    private boolean online;

    // Default constructor
    public GameServer() {
        serverName = "Unknown";
        ipAddress = "127.0.0.1";
        port = 5000;
        region = "Asia";
        maxPlayers = 100;
        currentPlayers = 0;
        online = false;
    }

    // Parameterized constructor
    public GameServer(String name, String ip, int p, String reg, int max) {
        serverName = name;
        ipAddress = ip;
        port = p;
        region = reg;
        maxPlayers = max;
        currentPlayers = 0;
        online = false;
    }

    // Getter methods
    public String getServerName() {
        return serverName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }

    public String getRegion() {
        return region;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getCurrentPlayers() {
        return currentPlayers;
    }

    public boolean getOnline() {
        return online;
    }

    // Setter methods
    public void setServerName(String name) {
        serverName = name;
    }

    public void setIpAddress(String ip) {
        ipAddress = ip;
    }

    // check the port number first
    public void setPort(int p) {
        if (p > 0 && p <= 65535) {
            port = p;
        } else {
            System.out.println("Wrong port number!");
        }
    }

    public void setRegion(String reg) {
        region = reg;
    }

    // max players cannot be 0 or negative
    public void setMaxPlayers(int max) {
        if (max > 0) {
            maxPlayers = max;
        } else {
            System.out.println("Wrong max players!");
        }
    }

    // players cannot be negative or more than max
    public void setCurrentPlayers(int players) {
        if (players >= 0 && players <= maxPlayers) {
            currentPlayers = players;
        } else {
            System.out.println("Wrong player number!");
        }
    }

    public void setOnline(boolean status) {
        online = status;
    }

    // Other methods

    // add players into the server
    public void addPlayers(int amount) {
        if (online == false) {
            System.out.println("Server is offline. Cannot join.");
        } else if (currentPlayers + amount > maxPlayers) {
            System.out.println("Server is full. Cannot join.");
        } else {
            currentPlayers = currentPlayers + amount;
            System.out.println(amount + " players joined.");
        }
    }

    // remove players from the server
    public void removePlayers(int amount) {
        if (amount > currentPlayers) {
            currentPlayers = 0;
        } else {
            currentPlayers = currentPlayers - amount;
        }
        System.out.println(amount + " players left.");
    }

    // calculate how full the server is (in percent)
    public double getLoad() {
        double load = currentPlayers * 100.0 / maxPlayers;
        return load;
    }

    // print all the server details
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("Server Name : " + serverName);
        System.out.println("IP Address  : " + ipAddress);
        System.out.println("Port        : " + port);
        System.out.println("Region      : " + region);
        System.out.println("Players     : " + currentPlayers + "/" + maxPlayers);
        System.out.println("Load        : " + getLoad() + "%");
        System.out.println("Online      : " + online);
        System.out.println("-----------------------------");
    }
}
