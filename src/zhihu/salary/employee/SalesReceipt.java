package zhihu.salary.employee;

import java.time.LocalDate;

/**
 * 销售单 -销售人员专项
 * Created by ASUS on 2017/7/31.
 */
public class SalesReceipt {
    private double amount;  //销售额
    private LocalDate saleDate; //销售日期
    //其他属性...

    public SalesReceipt(LocalDate saleDate, double amount) {
        this.saleDate = saleDate;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }
}
