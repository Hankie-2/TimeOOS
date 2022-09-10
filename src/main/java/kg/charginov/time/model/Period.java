package kg.charginov.time.model;


import kg.charginov.time.service.DateService;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Period {

    Integer day;

    Integer month;

    Integer year;

    public Period(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Period between(Date from, Date to){
        if(from.getYear()>to.getYear()){
            throw new IllegalArgumentException("'from' year must be greater than 'to' year");
        }

        LocalDate toLocal = LocalDate.of(from.getYear(), DateService.monthToInt(from.getMonth()),from.getDay());
        LocalDate fromLocal = LocalDate.of(to.getYear(),DateService.monthToInt(to.getMonth()),to.getDay());

        java.time.Period period = java.time.Period.between(toLocal,fromLocal);

        return new Period(period.getDays(),period.getMonths(),period.getYears());
    }

}
