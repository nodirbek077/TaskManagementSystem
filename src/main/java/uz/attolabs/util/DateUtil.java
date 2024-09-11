package uz.attolabs.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateUtil {
    public LocalDate getDate(LocalDate date){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        String getDate = dateFormat.format(currentDate);
        return LocalDate.parse(getDate);
    }
}
