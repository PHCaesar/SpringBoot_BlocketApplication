package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Component
public class TemporalValueFactory {
    public LocalDateTime create_datetimestamp(){
        return LocalDateTime.now();
    }
    public LocalDate create_datestamp() { return LocalDate.now();}
    public LocalTime create_timestamp(){return  LocalTime.now(); }
}