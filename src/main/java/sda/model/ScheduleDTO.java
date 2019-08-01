package sda.model;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ScheduleDTO {

    public int id;
    public Date date;
    public String movie_id;
    public String hall_id;

    public ScheduleDTO(int id, Date date, String movie_id, String hall_id) {
        this.id = id;
        this.date = date;
        this.movie_id = movie_id;
        this.hall_id = hall_id;
    }


}
