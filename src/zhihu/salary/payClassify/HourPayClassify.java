package zhihu.salary.payClassify;

import zhihu.salary.Util.DateUtil;
import zhihu.salary.employee.TimeCard;
import zhihu.salary.pay.PayDetail;

import java.time.LocalDate;
import java.util.Map;

/**
 * 小时工
 * Created by ASUS on 2017/7/31.
 */
public class HourPayClassify implements PayClassify{
    private double rate;
    private Map<LocalDate, TimeCard> timeCards;
    public HourPayClassify(double hourlyRate) {
        this.rate = hourlyRate;
    }
    public void addTimeCard(TimeCard tc){
        timeCards.put(tc.getDate(), tc);
    }
    @Override
    public double calculatePay(PayDetail detail) {
        double totalPay = 0;
        for(TimeCard tc : timeCards.values()){
            if(DateUtil.between(tc.getDate(), detail.getPayPeriodStartDate(),
                    detail.getPayPeriodEndDate())){
                totalPay += calculatePayForTimeCard(tc);
            }
        }
        return totalPay;
    }
    private double calculatePayForTimeCard(TimeCard  tc) {
        int hours = tc.getHours();
        if(hours > 12){
            return 12*rate + (hours-12) * rate * 2;
        } else{
            return 12*rate;
        }
    }
}
