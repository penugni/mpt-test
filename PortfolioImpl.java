package mpt;

import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.math.MathException;

public class PortfolioImpl {
	
	private Portfolio portfolio;
	private ConcurrentHashMap<Portfolio, Simulator> map;
	private static final double INFLATION_RATE = 0.035;
	private static final int INVESTMENT_PERIOD_YRS = 20;
	private static final long SIMULATIONS = 10000;
	
	public PortfolioImpl(PortfolioType type) {
		this.portfolio = new Portfolio(type);
		this.map = new ConcurrentHashMap<Portfolio, Simulator>();
		map.put(this.portfolio, this.portfolio.getSimulator());
	}

	public String getCalcSimulation() throws MathException {
		for (int i = 0; i < SIMULATIONS; i++) {
			double amount=portfolio.getInitialInvestment();
			for(int j = 0; j < INVESTMENT_PERIOD_YRS;j++){
				double ret = map.get(portfolio).nextSampleReturn();
				amount = amount * (1+ret);
				amount = amount * (1-INFLATION_RATE);
			}
			map.get(portfolio).saveSimulationResult(amount);
		}
		Simulator simulator = map.get(portfolio);
		portfolio.setSimulationMedian(simulator.getPercentile(50));
		portfolio.setSimulationTop10(simulator.getPercentile(90));
		portfolio.setSimulationBottom10(simulator.getPercentile(10));
		return portfolio.toString();
	}
}
