package mission.couponDiscount;

public class BaroCoupon implements Coupon {

    @Override
    public boolean isAvailableApply(int price) {
        return price == 1000;
    }

    @Override
    public int priorityCheck() {
        return 1;
    }

    @Override
    public int discountPrice(int price) {
        return 1000;
    }
}
