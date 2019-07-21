package sda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hall")
public class Hall {
    @Id
    @Column(name = "id",
            unique = true,
            nullable = false)
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Integer id;


    @Column(name = "name")
    private String name;

    @Column(name = "row")
    private Integer row;

    @Column(name = "seat")
    private Integer seat;

    @OneToMany(mappedBy = "id")
    List<Schedule> scheduleList;

    public Hall(String name, Integer row, Integer seat) {
        this.name = name;
        this.row = row;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "idHall=" + id +
                ", hallName='" + name +
                ", numberOfRows ='" + row +
                "numberOfSeats=" + seat +'\'' +
                '}';
    }
    public Integer getId() {
        return id;
    }

    public Hall setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Hall setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getRow() {
        return row;
    }

    public Hall setRow(Integer row) {
        this.row = row;
        return this;
    }

    public Integer getSeat() {
        return seat;
    }

    public Hall setSeat(Integer seat) {
        this.seat = seat;
        return this;
    }



}
