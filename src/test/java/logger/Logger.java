package logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    String dateTime;

    public void info(String info) {
        this.dateTime = DateTimeFormatter.ofPattern("dd.MM.yyy, hh.mm.ss")
                .format(LocalDateTime.now());
        System.out.println(dateTime + " LOG.INFO " + info);
    }
}
