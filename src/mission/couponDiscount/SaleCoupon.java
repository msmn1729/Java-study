package mission.couponDiscount;

public class SaleCoupon extends SortedCoupon {

    @Override
    public boolean isAvailableApply(int price) {
        if (price < 5000) {
            System.out.println("5,000원 미만인 상품에는 적용할 수 없습니다.");
            return false;
        }
        return true;
    }

    @Override
    public int priorityCheck() {
        return 2;
    }

    @Override
    public int discountPrice(int price) {
        return price / 10;
    }
}
