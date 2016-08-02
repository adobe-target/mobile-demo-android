package com.dailydeals.model;

// TODO: Auto-generated Javadoc
/**
 * The Class DataDeals is a simple Java Bean that is used to hold Background path ,
 * title , subtitle , pices and the bought product details.
 */
public class DataDeals {
	
	/** The Background image for the Deal. */
	private int bgMain;
	
	/** The Head Title. */
	private String txt1;
	
	/** The sub title . */
	private String txt2;
	
	/** The Striked price. */
	private String tv1;
	
	/** The New price. */
	private String tv2;
	
	/** The Bought deals. */
	private String tv4;
	
	/**
	 * Instantiates a new data deals.
	 *
	 * @param bgMain the bg main
	 * @param txt1 the txt1
	 * @param txt2 the txt2
	 * @param tv1 the tv1
	 * @param tv2 the tv2
	 * @param tv4 the tv4
	 */
	public DataDeals(int bgMain, String txt1, String txt2, String tv1,
			String tv2, String tv4) {
		super();
		this.bgMain = bgMain;
		this.txt1 = txt1;
		this.txt2 = txt2;
		this.tv1 = tv1;
		this.tv2 = tv2;
		this.tv4 = tv4;
	}
	
	/**
	 * Gets the bg main.
	 *
	 * @return the bg main
	 */
	public int getBgMain() {
		return bgMain;
	}
	
	/**
	 * Gets the txt1.
	 *
	 * @return the txt1
	 */
	public String getTxt1() {
		return txt1;
	}
	
	/**
	 * Gets the txt2.
	 *
	 * @return the txt2
	 */
	public String getTxt2() {
		return txt2;
	}
	
	/**
	 * Gets the tv1.
	 *
	 * @return the tv1
	 */
	public String getTv1() {
		return tv1;
	}
	
	/**
	 * Gets the tv2.
	 *
	 * @return the tv2
	 */
	public String getTv2() {
		return tv2;
	}
	
	/**
	 * Gets the tv4.
	 *
	 * @return the tv4
	 */
	public String getTv4() {
		return tv4;
	}
	
	

}
