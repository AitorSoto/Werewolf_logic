package POJOS;

public class Villager {
    private int id;
    private String name;
    private Roles role;
    private boolean alive;

    public Villager(){
        
    }

    public Villager(int id, String name, boolean alive, Roles role) {
        this.id = id;
        this.name = name;
        this.alive = alive;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Villager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", alive=" + alive +
                '}';
    }
}
