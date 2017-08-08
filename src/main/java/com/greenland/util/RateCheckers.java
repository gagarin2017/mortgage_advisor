package com.greenland.util;

import com.greenland.model.BOIRateChecker;
import com.greenland.model.RateChecker;
import com.greenland.util.services.BOIRateCheckerService;
import com.greenland.util.services.RateCheckerService;

/**
 * 
 * 
 * @author Yury
 *
 */
public enum RateCheckers {
	
	BOI() {
		@Override
		public RateCheckerService getRelevantService() {
			return new BOIRateCheckerService();
		}

		@Override
		public Class<? extends RateChecker> getRateCheckerClassType() {
			return BOIRateChecker.class;
		}
	};
	
	public abstract Class<? extends RateChecker> getRateCheckerClassType();
	public abstract RateCheckerService getRelevantService();

}
