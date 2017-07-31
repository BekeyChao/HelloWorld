package zhihu.salary.payDate;

import zhihu.salary.Util.DateUtil;

import java.time.LocalDate;

/**
 * 月底支付
 * 固定薪资：每个月的最后一个工作日对他们进行支付，在员工中有个月薪字段；
 * Created by ASUS on 2017/7/31.
 */
public class MonthlyPay implements PayDateUtil{
    @Override
    public boolean isPayDate(LocalDate date) {
        return DateUtil.isLastDayOfMonth(date);
    }
    @Override
    public LocalDate getPayPeriodStartDate(LocalDate payPeriodEndDate) {
        return DateUtil.getFirstDay(payPeriodEndDate);
    }
}
