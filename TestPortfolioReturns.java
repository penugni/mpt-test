package mpt;

import org.apache.commons.math.MathException;
import org.junit.Test;

public class TestPortfolioReturns {
	@Test
	public void testPortfolioReturns() throws MathException {
		PortfolioImpl portfolioAgressive = new PortfolioImpl(PortfolioType.AGRESSIVE);
		System.out.println(portfolioAgressive.getCalcSimulation());
		PortfolioImpl portfolioConservative = new PortfolioImpl(PortfolioType.VERY_CONSERVATIVE);
		System.out.println(portfolioConservative.getCalcSimulation());
	}
}
