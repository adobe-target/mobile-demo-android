package com.dailydeals.model;

// TODO: Auto-generated Javadoc
/**
 * The Data class hold the information of the image and the title 
 * text for the listview options .
 */
public class Data
{

	/** The title. */
	private String title;

	/** The image. */
	private int image;
	
	/** The sel. */
	private String sel;
	
	/** The image selected. */
	private int imageSelected;

	/**
	 * Gets the image selected.
	 *
	 * @return the image selected
	 */
	public int getImageSelected() {
		return imageSelected;
	}

	/**
	 * Gets the sel.
	 *
	 * @return the sel
	 */
	public String getSel() {
		return sel;
	}

	/**
	 * Sets the sel.
	 *
	 * @param sel the new sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
	}

	/**
	 * Instantiates a new data.
	 *
	 * @param title the title
	 * @param image the image
	 * @param img2 the img2
	 */
	public Data(String title, int image , int img2) {
		super();
		this.title = title;
		this.image = image;
		this.imageSelected = img2;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public int getImage() {
		return image;
	}	
	
}
