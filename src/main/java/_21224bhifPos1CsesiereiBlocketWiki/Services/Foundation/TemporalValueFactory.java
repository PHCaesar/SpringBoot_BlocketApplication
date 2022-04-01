package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class TemporalValueFactory {
    public LocalDateTime create_timestamp(){
        return LocalDateTime.now();
    }
}