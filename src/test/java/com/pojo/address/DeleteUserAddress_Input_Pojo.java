package com.pojo.address;

/**
 * @see Add Delete Address Request body Input POJO
 * @author Mohamed Anifa S
 *
 */
public class DeleteUserAddress_Input_Pojo {
	private String address_id;

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public DeleteUserAddress_Input_Pojo(String address_id) {
		super();
		this.address_id = address_id;
	}

}
