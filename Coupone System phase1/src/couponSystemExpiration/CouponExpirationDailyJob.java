package couponSystemExpiration;

import java.util.ArrayList;
import java.util.Date;

import couponeSystemBeans.Coupon;
import couponeSystemDAO.CouponsDAO;

public class CouponExpirationDailyJob implements Runnable {

	private CouponsDAO couponsDAO;
	private boolean quit;

	public CouponExpirationDailyJob(CouponsDAO couponsDAO, boolean quit) {
		super();
		this.couponsDAO = couponsDAO;
		this.quit = quit;
	}

	@Override
	public void run() {
		this.quit = true;
		while (this.quit) {
			ArrayList<Coupon> coupons = this.couponsDAO.getAllCoupons();
			for (Coupon var : coupons) {
				if (var.getEndDate().compareTo(new Date()) == 0) {
					this.couponsDAO.deleteCoupon(var.getId());
				}
			}
			try {
				coupons.clear();
				// Wait for 24 hour.
				Thread.sleep(86400000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		this.quit = false;
	}
}
