package kg.charginov.time;

import kg.charginov.time.model.Date;
import kg.charginov.time.model.Period;
import kg.charginov.time.model.enums.Month;

public class Main {
    public static void main(String[] args){
        Date date = new Date(2022, Month.NOVEMBER,4);

        /*
        – получения года getYear типа Integer;
        – получения месяца getMonth типа Month;
        – получения дня getDayOfMonth типа Integer;
        – получения дня недели getDayOfWeek типа DayOfWeek.
         */
        System.out.println(date.getYear());         // Output: 2022
        System.out.println(date.getMonth());        // Output: NOVEMBER
        System.out.println(date.getDay());          // Output: 4
        System.out.println(date.getWeek());         // Output: FRIDAY


        /*
        Добавьте классу Date общедоступную статическую операцию now () типа Date.
         */
        System.out.println(Date.now());             // Output: сегодняшняя дата

        /*
        Добавьте классу Period общедоступную статическую операцию between.
        У операции два аргумента: from и to.
        Оба аргумента имеют тип Date.
        Операция возвращает значение типа Period
         */
        Date date1 = new Date(2002, Month.NOVEMBER,12);
        Date date2 = new Date(2022, Month.SEPTEMBER,22);
        System.out.println(Period.between(date1,date2));    // Output: Period(day=10, month=10, year=19) -> разница между датой date1 и date2

        /*
        Добавьте классу Date операцию plus c аргументом delta типа Period.
        Результат операции – значение типа Date.
         */
        Date date3 = new Date(2000, Month.APRIL,1);
        System.out.println(date3.plus(new Period(1,1,1)));    // Output: Date(year=2001, month=MAY, day=2, week=WEDNESDAY)
    }
}
