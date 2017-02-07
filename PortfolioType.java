package mpt;

public enum PortfolioType {
	AGRESSIVE, VERY_CONSERVATIVE;
		
	//made assumption that default is convervative
	public static double getMeanFromPortfolioType(PortfolioType type) {
		if(type == PortfolioType.AGRESSIVE) return Double.parseDouble("0.094324");
		else return Double.parseDouble("0.06189");
	}
	
	public static double getStandardDeviationFromPortfolioType(PortfolioType type) {
		if(type == PortfolioType.AGRESSIVE) return Double.parseDouble("0.15675");
		else return Double.parseDouble("0.063438");
	}
	
	public static double getInvestmentAmount(){
		return Double.parseDouble("100000");
	}

}
