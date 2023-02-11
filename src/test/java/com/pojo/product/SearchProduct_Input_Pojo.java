package com.pojo.product;



/**
 * @see Add Search Product Request body Input POJO
 * @author Mohamed Anifa S
 *
 */
public class SearchProduct_Input_Pojo {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public SearchProduct_Input_Pojo(String text) {
		super();
		this.text = text;
	}

}
