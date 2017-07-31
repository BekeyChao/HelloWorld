package zhihu.salary.Util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 日期/日历计算工具类
 * Created by ASUS on 2017/7/31.
 */
public class DateUtil {
    /**
     * @param d 测试日期
     * @return 返回是否是星期五
     */
    public static boolean isFriday(LocalDate d) {
        return d.getDayOfWeek() == DayOfWeek.FRIDAY ;
    }

    /**
     * @param d 测试日期
     * @return 返回是否是月底
     */
    public static boolean isLastDayOfMonth(LocalDate d) {
        return d.lengthOfMonth() == d.getDayOfMonth();
    }
    //what means
    public static LocalDate getFirstDay(LocalDate payPeriodEndDate) {
        return null;
    }

    /**
     * @param s 格式化日期
     * @return 返回日期
     */
    public static LocalDate parseDate(String s) {
        return LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE);
    }

    /**
     * @param start 开始日期
     * @param end 结束日期
     * @return 日期间隔天数
     */
    public static long getDaysBetween(LocalDate start, LocalDate end) {
        Period p = Period.between(start,end);
        return p.getDays();
    }

    /**
     * @param date 初始日期
     * @param i 间隔天数
     * @return 返回相加后的新日期
     */
    public static LocalDate add(LocalDate date, int i) {
        return date.plusDays(i);
    }

    /**
     * @param targetDate 目标日期
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 目标日期是否在开始与结束日期之间
     */
    public static boolean between(LocalDate targetDate, LocalDate startDate, LocalDate endDate) {
        return targetDate.isAfter(startDate) && targetDate.isBefore(endDate);
    }
}
