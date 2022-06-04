package mission.couponDiscount;

public class BaroCoupon implements Coupon {

    @Override
    public String getName() {
        return "BaroCoupon";
    }

    @Override
    public boolean isAvailableApply(int price) {
        if (price < 1000) {
            System.out.print("1,000원 미만 상품에는 적용할 수 없습니다.");
            return false;
        }
        return true;
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
