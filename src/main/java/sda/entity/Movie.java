package sda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @Column(name = "id",
            unique = true,
            nullable = false)
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column (name = "running")
    public int running;

    private Movie(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "idMovie=" + id +
                ", movieName='" + name +
                "isRunning=" + running +'\'' +
                '}';
    }


    private Movie() {}

    public Integer getId() {
        return id;
    }

    public Movie setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getRunning() {
        return running;
    }

    public Movie setRunning(Integer running) {
        this.running = running;
        return this;
    }

}
