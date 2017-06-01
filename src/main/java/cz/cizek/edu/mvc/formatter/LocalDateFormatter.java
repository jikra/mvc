package cz.cizek.edu.mvc.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

/**
 * @author jiricizek <jiri.cizek@cleverlance.com>
 */
public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.now();
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return "12-2-2017";
    }
}
