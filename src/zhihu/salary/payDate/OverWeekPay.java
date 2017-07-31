package zhihu.salary.payDate;

import zhihu.salary.Util.DateUtil;

import java.time.LocalDate;

/**
 * 隔周支付
 * 销售员：带薪的员工，按照提成比例给佣金。提交销售凭条，记录日期和金额。在员工中有一个提成比例字段。 每隔一周的周五支付；
 * Created by ASUS on 2017/7/31.
 */
public class OverWeekPay implements PayDateUtil{
    //指定一个星期五
    LocalDate firstPayableFriday = DateUtil.parseDate("2017-6-2");

    @Override
    public boolean isPayDate(LocalDate date) {
        long interval = DateUtil.getDaysBetween(firstPayableFriday, date);
        return interval % 14 == 0;
    }

    @Override
    public LocalDate getPayPeriodStartDate(LocalDate payPeriodEndDate) {
        //上一个支付日
        return DateUtil.add(payPeriodEndDate, -13);
    }
}
