package zoo.simulation;

public class Time {

    private int year;
    private int month;
    private int day;

    private int totalDays;

    private final int MONTHS_IN_YEAR = 12;
    private final int DAYS_IN_MONTH = 30;

    public Time() {
        day= 0;
        month= 0;
        year= 0;
    }

    public void updateTime() {
        if (day > DAYS_IN_MONTH) {
            month += day / DAYS_IN_MONTH ;
            day = day % DAYS_IN_MONTH ;
        }
        if (month > MONTHS_IN_YEAR) {
            year += month / MONTHS_IN_YEAR;
            month = month % MONTHS_IN_YEAR;
        }
    }

    public void timePasses(int day) {
        this.day += day ;
        totalDays += day;
        updateTime();
    }

    public int getDays() {
        return totalDays ;
    }

    public String getDate() {
        String date = "" ;
        if (year != 0) {
            date += "Year: " + year + " | " ;
        }
        date += "Months: " + month + " | " ;
        date += "Days: " + day ;
        return date;
    }

    public void displayDate() {
        System.out.println(getDate());
    }
}
