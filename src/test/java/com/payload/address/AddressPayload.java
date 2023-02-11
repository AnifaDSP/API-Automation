package com.payload.address;

import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.CityList_Input_Pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.UptateUserAddress_Input_Pojo;

/**
 * @see Maintain all the Payload in address page
 * @author Mohamed Anifa S
 *
 */
public class AddressPayload {
	/**
	 * @see Add address payload
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @return addUserAddress_Input_Pojo
	 */
	public AddUserAddress_Input_Pojo addUserAddressPayload(String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo(first_name, last_name,
				mobile, apartment, state, city, country, zipcode, address, address_type);
		return addUserAddress_Input_Pojo;
	}

	/**
	 * @see Uptate address payload
	 * @param address_id
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @return uptateUserAddress_Input_Pojo
	 */
	public UptateUserAddress_Input_Pojo uptateUserAddressPayload(String address_id, String first_name, String last_name,
			String mobile, String apartment, int state, int city, int country, String zipcode, String address,
			String address_type) {
		UptateUserAddress_Input_Pojo uptateUserAddress_Input_Pojo = new UptateUserAddress_Input_Pojo(address_id,
				first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return uptateUserAddress_Input_Pojo;
	}

	/**
	 * @see delete address payload
	 * @param address_id
	 * @return deleteUserAddress_Input_Pojo
	 */
	public DeleteUserAddress_Input_Pojo deleteUserAddressPayload(String address_id) {
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(address_id);
		return deleteUserAddress_Input_Pojo;
	}

	/**
	 * @see City list payload
	 * @param state_Id
	 * @return cityList_Input_Pojo
	 */
	public CityList_Input_Pojo cityListPayload(String state_Id) {
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(state_Id);
		return cityList_Input_Pojo;
	}
}
