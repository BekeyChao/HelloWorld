package zhihu.salary.pay;

/**
 * 扣除项：
 在雇员记录中有一个每周应付款项字段，这些应付款需要从他们的薪水中扣除。
 * Created by ASUS on 2017/7/31.
 */
public interface Reduce {
    public double calculateDeductions(PayDetail detail);
}
