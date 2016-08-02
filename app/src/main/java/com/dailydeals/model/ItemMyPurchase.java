package com.dailydeals.model;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemMyPurchase is a simple Java Bean that is used to hold the image path,
 * item name , date , price and the status of item .
 */
public class ItemMyPurchase {
	
	/** The item image. */
	private int itemImage;
	
	/** The item name. */
	private String itemName;
	
	/** The item date. */
	private String itemDate;
	
	/** The item price. */
	private String itemPrice;
	
	/** The item status. */
	private String itemStatus;
	
	/**
	 * Instantiates a new item my purchase.
	 *
	 * @param itemImage the item image
	 * @param itemName the item name
	 * @param itemDate the item date
	 * @param itemPrice the item price
	 * @param itemStatus the item status
	 */
	public ItemMyPurchase(int itemImage, String itemName, String itemDate,
			String itemPrice, String itemStatus) {
		super();
		this.itemImage = itemImage;
		this.itemName = itemName;
		this.itemDate = itemDate;
		this.itemPrice = itemPrice;
		this.itemStatus = itemStatus;
	}

	/**
	 * Gets the item image.
	 *
	 * @return the item image
	 */
	public int getItemImage() {
		return itemImage;
	}
	
	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Gets the item date.
	 *
	 * @return the item date
	 */
	public String getItemDate() {
		return itemDate;
	}
	
	/**
	 * Gets the item price.
	 *
	 * @return the item price
	 */
	public String getItemPrice() {
		return itemPrice;
	}
	
	/**
	 * Gets the item status.
	 *
	 * @return the item status
	 */
	public String getItemStatus() {
		return itemStatus;
	}
	

}
