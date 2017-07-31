package zhihu.salary.employee;

import java.time.LocalDate;

/**
 * 销售单 -销售人员专项
 * Created by ASUS on 2017/7/31.
 */
public class SalesReceipt {
    private double amount;
    private LocalDate saleDate;

    public double getAmount() {
        return amount;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }
}
