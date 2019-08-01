package sda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    public Schedule(Timestamp date) {
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
                ",screeningDate=" + date +'\'' +
                ",hallName=" + hall.getName() +
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

  //  @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }

    public Schedule setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getMovieName() {
        return movie.name;
    }

    public String getHallName(){
        return hall.name;
    }


}
