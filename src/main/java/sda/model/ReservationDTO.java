package sda.model;

public class ReservationDTO {

   public int id;
   public int row_number;
   public int seat_number;
   public String schedule_id;
   public String code;

    public ReservationDTO(int id, int row_number, int seat_number, String schedule_id, String code) {
        this.id = id;
        this.row_number = row_number;
        this.seat_number = seat_number;
        this.schedule_id = schedule_id;
        this.code = code;
    }
}
