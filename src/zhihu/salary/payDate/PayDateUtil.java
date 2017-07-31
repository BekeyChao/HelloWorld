package zhihu.salary.payDate;

import java.time.LocalDate;

/**
 * 支付按照员工类型有三种方式 -每周 -隔周 -月底
 * Created by ASUS on 2017/7/31.
 */
public interface PayDateUtil {
    public boolean isPayDate(LocalDate d);

    public LocalDate getPayPeriodStartDate(LocalDate d);
}
