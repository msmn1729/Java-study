package mission.couponDiscount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCoupon implements Coupon {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date expiredDate;

    public DateCoupon(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public boolean isAvailableApply(int price) throws ParseException {
        String todayStr = dateFormat.format(new Date());
        Date today = dateFormat.parse(todayStr);
        if (today.compareTo(expiredDate) > 0) {
            System.err.println("유효기간이 지난 쿠폰입니다.");
            return false;
        }
        if (price < 3000) {
            System.err.println("3,000원 이상인 상품에 사용가능한 쿠폰입니다.");
            return false;
        }
        return true;
    }

    @Override
    public int priorityCheck() {
        return 3;
    }

    @Override
    public int discountPrice(int price) {
        return 3000;
    }
}
