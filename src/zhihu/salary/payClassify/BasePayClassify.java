package zhihu.salary.payClassify;

import zhihu.salary.pay.PayDetail;

/**
 * 月底结薪员工
 * Created by ASUS on 2017/7/31.
 */
public class BasePayClassify implements PayClassify{
    private double salary;
    public BasePayClassify(double salary){
        this.salary = salary;
    }
    @Override
    public double calculatePay(PayDetail pc) {
        return salary;
    }
}
