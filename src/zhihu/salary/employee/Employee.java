package zhihu.salary.employee;

import zhihu.salary.payClassify.PayClassify;
import zhihu.salary.pay.PayDetail;
import zhihu.salary.pay.PaymentMethod;
import zhihu.salary.pay.Reduce;
import zhihu.salary.payDate.PayDateUtil;

import java.time.LocalDate;


/**
 * 雇员
 * Created by BEKEY on 2017/7/31.
 */
public class Employee {
    private String id;
    private String name;
    private Integer age;
    private Integer sex;
    private PayClassify classify;//支付策略类型
    private PayDateUtil payDateUtil;//支付时间抽象类
    private PaymentMethod paymentMethod;//支付方式
    private Reduce reduce;//扣除项

    public Employee(String id,String name) {
        this.id = id;
        this.name = name;
    }
    //是否为发薪日
    public boolean isPayDay(LocalDate d) {
        return this.payDateUtil.isPayDate(d);
    }
    //上一结薪日
    public LocalDate getStartDate(LocalDate d) {
        return this.payDateUtil.getPayPeriodStartDate(d);
    }

    //发薪方法
    public void payDay(PayDetail detail){
        double grossPay = classify.calculatePay(detail);
        double deductions = reduce.calculateDeductions(detail);
        double netPay = grossPay - deductions;
        detail.setGrossPay(grossPay);
        detail.setDeductions(deductions);
        detail.setNetPay(netPay);
        paymentMethod.pay(detail);
    }
}
