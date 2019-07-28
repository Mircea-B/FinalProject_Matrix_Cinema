package sda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "reservation")

public class Reservation {
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

    @Column(name = "row_number")
    private Integer rowNumber;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "code")
    private String reservationCode;


    @ManyToOne
    @JoinColumn(name = "schedule_id")
    Schedule schedule;


    public Reservation(Integer rowNumber, Integer seatNumber, String reservationCode) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.reservationCode = reservationCode;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + id +
                ", scheduleDate=" + schedule.getDate() +
                ", rowNumber='" + rowNumber +
                ", seatNumber ='" + seatNumber +
                "reservationCode=" + reservationCode +'\'' +
                '}';
    }

    private Reservation(){}

    public Integer getId() {
        return id;
    }

    public Reservation setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Reservation setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
        return this;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public Reservation setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public Reservation setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
        return this;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Reservation setSchedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public String getScheduleInfo(){
        return schedule.toString();
    }
}
