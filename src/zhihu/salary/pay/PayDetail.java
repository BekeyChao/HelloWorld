package zhihu.salary.pay;


import java.time.LocalDate;

/**
 * 支付细节
 * Created by ASUS on 2017/7/31.
 */
public class PayDetail {
    private double grossPay;
    private double deductions;
    private double netPay;

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public LocalDate getPayPeriodStartDate() {
        return null;
    }

    public LocalDate getPayPeriodEndDate() {
        return null;
    }
}
