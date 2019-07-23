package sda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "schedule")

public class Schedule {
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

    @Column(name = "date")
    private Date date;

    public Schedule(Date date) {
        this.date = date;
    }

    @OneToOne
    @JoinColumn(name = "movie_id")
    Movie movie;

    @OneToMany(mappedBy = "schedule")
    List<Reservation> reservationList;


    @OneToOne
    @JoinColumn(name = "hall_id")
    Hall hall;


    @Override
    public String toString() {
        return "Schedule{" +
                "idSchedule=" + id +
                ", movieName='" + movie.getName() +
                "screeningDate=" + date +'\'' +
                "hallName=" + hall.getName() +
                '}';
    }

    private Schedule(){}

    public Integer getId() {
        return id;
    }

    public Schedule setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Schedule setDate(Date date) {
        this.date = date;
        return this;
    }


}
