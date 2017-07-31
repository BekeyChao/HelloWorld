package zhihu.salary.payClassify;

import zhihu.salary.Util.DateUtil;
import zhihu.salary.employee.SalesReceipt;
import zhihu.salary.pay.PayDetail;

import java.time.LocalDate;
import java.util.Map;

/**
 * 销售人员
 * Created by ASUS on 2017/7/31.
 */
public class SalesPayClassify implements PayClassify{
    double salary;
    double rate;
    public SalesPayClassify(double salary , double rate){
        this.salary = salary;
        this.rate = rate;
    }
    Map<LocalDate, SalesReceipt> receipts;
    @Override
    public double calculatePay(PayDetail detail) {
        double commission = 0.0;
        for(SalesReceipt sr : receipts.values()){
            if(DateUtil.between(sr.getSaleDate(), detail.getPayPeriodStartDate(),
                    detail.getPayPeriodEndDate())){
                commission += sr.getAmount() * rate;
            }
        }
        return salary + commission;
    }
}
