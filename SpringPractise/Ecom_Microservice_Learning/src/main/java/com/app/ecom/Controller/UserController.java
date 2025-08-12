package com.app.ecom.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecom.DTO.UserRequest;
import com.app.ecom.DTO.UserResponse;
import com.app.ecom.Model.User;
import com.app.ecom.Services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userservice;

	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}

	private List<User> userList = new ArrayList<>();

	@GetMapping("/api/users")

	public ResponseEntity<List<UserResponse>> getAllUsers() {
		return new ResponseEntity<>(userservice.fetchAllUsers(), HttpStatus.OK);

		/*
		 * return ResponseEntity.ok(userservice.FetchAllUsers());
		 */ }

	@PostMapping("/api/users")
	public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
		User createdUser = userservice.AddUser(userRequest);
		return ResponseEntity.ok("User Added Successfully.........");
	}

	@GetMapping("/api/users/{id}")
	public ResponseEntity<Optional<UserResponse>> getUser(@PathVariable Long id) {
		Optional<UserResponse> user = userservice.FetchUser(id);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(user);
	}

	@PutMapping("/api/users/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserRequest updatedUserRequest) {
		boolean updated = userservice.updateUser(id, updatedUserRequest);
		if (updated)
			return ResponseEntity.ok("User added successfully");
		return ResponseEntity.notFound().build();
	}
}
/*
 * 📦 What is @RequestBody?
 * 
 * @RequestBody is an annotation used in Spring MVC to bind the HTTP request
 * body to a Java object. It’s commonly used in RESTful APIs to receive data
 * from the client in formats like JSON or XML and convert it into a Java
 * object.
 * 
 * 🧠 How It Works - When a client sends a POST, PUT, or PATCH request with data
 * in the body (typically JSON), Spring uses HttpMessageConverters to
 * deserialize that data into the specified Java object. - The annotation tells
 * Spring: “Take the incoming request body and map it to this object.”
 */

/*
 * 🛣️ What is @PathVariable?
 * 
 * @PathVariable is an annotation used in Spring MVC to extract values from the
 * URI path and bind them to method parameters in a controller. It’s typically
 * used in REST APIs to capture dynamic segments of the URL.
 * 
 * 🧠 How It Works - When a client sends a request to a URL like /users/42,
 * Spring maps the 42 part to a method parameter annotated with @PathVariable. -
 * It matches the placeholder in the URL pattern (e.g., /users/{id}) with the
 * method argument.
 */

/*
 * 🔗 What is @RequestParam?
 * 
 * @RequestParam is an annotation used in Spring MVC to extract query parameters
 * from the URL and bind them to method parameters in a controller. It’s ideal
 * for handling optional or named parameters passed in the URL after the ?.
 * 
 * 🧠 How It Works - When a client sends a request like /search?keyword=spring,
 * Spring maps the keyword query parameter to a method argument annotated
 * with @RequestParam. - It supports automatic type conversion and can handle
 * default values or optional parameters.
 * 
 * 
 * 
 * @ResponseBody is an annotation in Spring MVC that tells the framework to
 * write the return value of a method directly to the HTTP response body,
 * instead of rendering a view. It’s essential for building RESTful APIs where
 * you return data (like JSON or XML) rather than HTML.
 * 
 * 🧠 How It Works - When a controller method is annotated with @ResponseBody,
 * Spring skips view resolution and instead uses HttpMessageConverters to
 * serialize the return value into the desired format (usually JSON). - It’s
 * typically used in combination with @Controller to expose REST endpoints.
 */

/*
 * 📦 What is ResponseEntity? ResponseEntity is a generic wrapper in Spring used
 * to represent the entire HTTP response, including: - Status code (e.g., 200
 * OK, 404 Not Found) - Headers (e.g., Content-Type, Location) - Body (e.g.,
 * JSON, plain text, or any object) It gives you fine-grained control over the
 * response sent back to the client.
 * 
 * 🧠 How It Works - Instead of just returning a data object, you return a
 * ResponseEntity<T> where T is the type of the response body. - You can set the
 * status code, headers, and body explicitly. - It’s especially useful for REST
 * APIs where you want to customize the response format and behavior.
 * 
 * 🔍 Key Methods of ResponseEntity | Method | Purpose | | ok(body) | Returns
 * 200 OK with a body | | status(HttpStatus) | Sets a custom status code | |
 * created(URI) | Returns 201 Created with a Location header | | accepted() |
 * Returns 202 Accepted | | noContent() | Returns 204 No Content | |
 * badRequest() | Returns 400 Bad Request | | notFound() | Returns 404 Not Found
 * | | internalServerError() | Returns 500 Internal Server Error | |
 * headers(HttpHeaders) | Adds custom headers | | body(T) | Sets the response
 * body | | build() | Finalizes the response without a body |
 * 
 * 
 * These methods are typically chained using the builder pattern.
 */
