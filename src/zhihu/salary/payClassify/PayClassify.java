package zhihu.salary.payClassify;

import zhihu.salary.pay.PayDetail;

/**
 * 支付方式：支票邮寄、保存在财务、银行转账；
 * Created by ASUS on 2017/7/31.
 */
public interface PayClassify {
    public double calculatePay(PayDetail detail);
}
