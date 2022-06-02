package mission.couponDiscount;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface Coupon {
    boolean isAvailableApply(int price) throws ParseException;

    int priorityCheck();

    int discountPrice(int price);
}
