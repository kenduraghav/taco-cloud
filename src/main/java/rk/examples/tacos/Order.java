package rk.examples.tacos;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class Order {

	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@NotBlank(message = "Phone No cannot be empty")
	private String phoneNo;
	
	@NotBlank(message="Email Id cannot be empty")
	@Email(message = "Please enter a valid email id")
	private String emailId;
	
	@NotBlank(message="Street cannot be empty")
	private String street;
	
	@NotBlank(message="City cannot be empty")
	private String city;
	
	@NotBlank(message="State cannot be empty")
	private String state;
	
	@NotBlank(message="Zipcode cannot be empty")
	private String zipcode;
	
	@CreditCardNumber(message="Not a valid credit card number")
	private String ccNumber;
	
	@Pattern(regexp = "^(0[1-9]|1[0-2])\\/?([0-9]{2})$", message="Must be formatted as MM/YY")
	private String ccExpiryDate;
	
	@Digits(integer = 3, fraction = 0, message = "Invalid CVV")
	private String cvvNumber;
}
