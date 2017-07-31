package zhihu.salary.pay;


import java.time.LocalDate;
import java.util.Map;

/**
 * 支付细节
 * Created by ASUS on 2017/7/31.
 */
public class PayDetail {
    private LocalDate start;
    private LocalDate end;
    private double grossPay;//应付
    private double netPay;//实发
    private double deductions;//扣除
    private Map<String, String> itsFields;//明细
    public PayDetail(LocalDate start, LocalDate end){
        this.start = start;
        this.end = end;
    }
    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }
    public void setDeductions(double deductions) {
        this.deductions  = deductions;
    }
    public void setNetPay(double netPay){
        this.netPay = netPay;
    }
    public LocalDate getPayPeriodEndDate() {
        return this.end;
    }
    public LocalDate getPayPeriodStartDate() {
        return this.start;
    }
}
