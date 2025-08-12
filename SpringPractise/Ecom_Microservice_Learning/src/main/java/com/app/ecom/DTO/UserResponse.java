package com.app.ecom.DTO;

import com.app.ecom.Model.UserRole;

import lombok.Data;
@Data
public class UserResponse {

	private String ID;
	private String firstname;
	private String Lastname;
	private String Email;
	private String phone;
	private UserRole role;
	private AddressDto address;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserResponse [ID=" + ID + ", firstname=" + firstname + ", Lastname=" + Lastname + ", Email=" + Email
				+ ", phone=" + phone + ", role=" + role + ", address=" + address + ", getID()=" + getID()
				+ ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname() + ", getEmail()="
				+ getEmail() + ", getPhone()=" + getPhone() + ", getRole()=" + getRole() + ", getAddress()="
				+ getAddress() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public UserResponse(String iD, String firstname, String lastname, String email, String phone, UserRole role,
			AddressDto address) {
		super();
		ID = iD;
		this.firstname = firstname;
		Lastname = lastname;
		Email = email;
		this.phone = phone;
		this.role = role;
		this.address = address;
	}
	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}







/*
 * 
 * 
 * ## 📦 DTO (Data Transfer Object)
 * 
 * ### ✅ Purpose - Encapsulates data exchanged between layers (Controller ↔
 * Service ↔ Client). - Prevents exposing internal entity structure. - Enables
 * validation and transformation of incoming/outgoing data.
 * 
 * ### 🔍 Types of DTOs
 * 
 * #### **UserRequest DTO** - Used to receive data from the client (e.g., during
 * creation or update). - Contains only fields the client is allowed to send. -
 * Often includes validation annotations like `@NotNull`, `@Email`, `@Size`.
 * 
 * #### **UserResponse DTO** - Used to send data back to the client. - Contains
 * only safe, relevant fields. - May include computed or formatted fields (e.g.,
 * `fullName`, `statusLabel`).
 * 
 * ### 🛠 Benefits - Improves security by hiding sensitive fields. - Enhances
 * flexibility for shaping API contracts. - Decouples domain models from
 * external interfaces. - Supports versioning and backward compatibility.
 * 
 * ---
 * 
 * ## 🧳 ModelWrapper / ResponseWrapper
 * 
 * ### ✅ Purpose - Wraps DTOs with metadata for standardized API responses. -
 * Useful for consistency across success and error responses.
 * 
 * ### 🔍 Common Fields
 * 
 * | Field | Description |
 * |---------------|--------------------------------------------------| | `data`
 * | The actual DTO or list of DTOs | | `message` | Human-readable status or
 * description | | `status` | HTTP status code or custom code | | `timestamp` |
 * When the response was generated | | `errors` | Optional list of validation or
 * business errors |
 * 
 * ### 🛠 Benefits - Standardizes API structure for frontend parsing. -
 * Simplifies error handling and debugging. - Enables inclusion of contextual
 * metadata (e.g., pagination, request ID).
 * 
 * ---
 * 
 * ## 🧱 Best Practices
 * 
 * - Never expose entity objects directly in controllers. - Use DTOs for both
 * request and response payloads. - Validate request DTOs using `@Valid` in
 * controller methods. - Use mapping libraries like **MapStruct** or
 * **ModelMapper** for clean conversions. - Keep DTOs lean and
 * purpose-specific—avoid bloated or reused DTOs across unrelated endpoints.
 * 
 * ---
 */

