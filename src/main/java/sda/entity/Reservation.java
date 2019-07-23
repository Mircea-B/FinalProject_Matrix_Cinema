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

}
