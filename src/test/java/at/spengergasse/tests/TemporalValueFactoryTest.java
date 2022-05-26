package at.spengergasse.tests;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class TemporalValueFactoryTest {

    @Autowired
    private TemporalValueFactory temporalValueFactory;

    @Test
    void ensureTemporalValueFactoryCreatesDateTimeStamp(){ assertEquals(temporalValueFactory.create_datetimestamp().getClass(), LocalDateTime.class);}

    @Test
    void ensureTemporalValueFactoryCreatesDateStamp(){ assertEquals(temporalValueFactory.create_datestamp().getClass(), LocalDate.class);}

    @Test
    void ensureTemporalValueFactoryCreatesTimeStamp(){ assertEquals(temporalValueFactory.create_timestamp().getClass(), LocalTime.class);}
}
