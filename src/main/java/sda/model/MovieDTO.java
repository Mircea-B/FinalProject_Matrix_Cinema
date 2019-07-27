package sda.model;

public class MovieDTO {

    public String name;
    public int id;
    public int running;

    public MovieDTO(String name, int id, int running) {
        this.name = name;
        this.id = id;
        this.running = running;
    }
}
