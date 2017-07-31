package zhihu.salary.employee;

import java.time.LocalDate;

/**
 * 工时卡 -小时工专项
 * Created by ASUS on 2017/7/31.
 */
public class TimeCard {
    private LocalDate date;
    private int hours;

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }
}
