package zhihu.salary.payDate;

import zhihu.salary.Util.DateUtil;

import java.time.LocalDate;

/**
 * 每周支付
 * 小时工：每天提交工作时间卡，记录了日、工作小时数，如果每天工作超过12小时，按2倍进行支付， 每周五支付；
 * Created by ASUS on 2017/7/31.
 */
public class WeeklyPay implements PayDateUtil {
    @Override
    public boolean isPayDate(LocalDate d) {
        return DateUtil.isFriday(d);
    }

    @Override
    public LocalDate getPayPeriodStartDate(LocalDate payPeriodEndDate) {
        return DateUtil.add(payPeriodEndDate, -6);
    }
}
