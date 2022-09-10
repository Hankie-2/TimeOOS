package kg.charginov.time.model;

import kg.charginov.time.model.enums.Month;
import kg.charginov.time.model.enums.Week;
import kg.charginov.time.service.DateService;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Date {

    Integer year;

    Month month;

    Integer day;

    Week week;

    public Date(Integer year, Month month, Integer day) {
        if(day>31 || day<0){
            throw new IllegalArgumentException("\"Day can't be less than 31 or greater than 0\"");
        }
        this.year = year;
        this.month = month;
        this.day = day;
        LocalDate date = LocalDate.of(year,DateService.monthToInt(month),day);
        this.week = Week.valueOf(date.getDayOfWeek()+"");
    }

    public static Date now(){
        return new Date(
                LocalDate.now().getYear(),
                Month.valueOf(LocalDate.now().getMonth()+""),
                LocalDate.now().getDayOfMonth());
    }

    public Date plus(Period delta){
        java.util.Date date = new GregorianCalendar(delta.getYear(),delta.getMonth(),delta.getDay()).getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        LocalDate d = LocalDate.of(this.year, DateService.monthToInt(this.month),this.day);
        c.add(Calendar.YEAR,d.getYear());
        c.add(Calendar.MONTH,DateService.monthToInt(Month.valueOf(d.getMonth()+"")));
        c.add(Calendar.DAY_OF_MONTH,d.getDayOfMonth());

        return new Date(c.get(Calendar.YEAR),Month.valueOf(DateService.intToMonth(c.get(Calendar.MONTH))),c.get(Calendar.DAY_OF_MONTH));
    }

}
