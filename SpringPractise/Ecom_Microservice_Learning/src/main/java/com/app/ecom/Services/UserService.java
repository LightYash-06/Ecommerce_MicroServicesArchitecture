package com.app.ecom.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.app.ecom.DTO.AddressDto;
import com.app.ecom.DTO.UserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import com.app.ecom.DTO.AddressDto;
*/import com.app.ecom.DTO.UserResponse;
import com.app.ecom.Model.User;
import com.app.ecom.Model.Address;

import com.app.ecom.Repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private final UserRepository userrepository;
	
	
	public UserService(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}
	
	/*
	 * private List<User> userList = new ArrayList<>();
	 */	
	public List<UserResponse> fetchAllUsers() {
	    return userrepository.findAll().stream()
	        .map(this::mapToUserResponse)
	        .collect(Collectors.toList());
	}
	
	public User AddUser(UserRequest userRequest) {
		
		User user = new User();
		updateUserFromRequest(user, userRequest);
		userrepository.save(user);
	    return user;
	}

	public Optional<UserResponse> FetchUser(Long id) {
		// TODO Auto-generated method stub
	return userrepository.findById(id)	.map(this::mapToUserResponse);

	}
	
	public boolean updateUser(Long id, UserRequest updatedUserRequest) {
	    return userrepository.findById(id)
	        .map(existingUser -> {
                updateUserFromRequest(existingUser, updatedUserRequest);
	            // Add other fields as needed
	            userrepository.save(existingUser);
	            return true;
	        })
	        .orElse(false);
	}
	private UserResponse mapToUserResponse(User user) {
	    UserResponse response = new UserResponse();
	    response.setID(String.valueOf(user.getID()));
	    response.setFirstname(user.getFirstname());
	    response.setLastname(user.getLastname());
	    response.setEmail(user.getEmail());
	    response.setPhone(user.getPhone());
	    response.setRole(user.getRole());

	    if (user.getAddress() != null) {
			/*
			 * AddressDTO addressDTO = new AddressDTO();
			 */	        
	    	AddressDto addressDTO = new AddressDto();
	        addressDTO.setStreet(user.getAddress().getStreet());
	        addressDTO.setCity(user.getAddress().getCity());
	        addressDTO.setState(user.getAddress().getState());
	        addressDTO.setCountry(user.getAddress().getCountry());
	        addressDTO.setZipcode(user.getAddress().getZipcode());
	        response.setAddress(addressDTO);
	    }

	    return response;
	}
	
	private void updateUserFromRequest(User user, UserRequest userRequest) {
	    user.setFirstname(userRequest.getFirstname());
	    user.setLastname(userRequest.getLastname());
	    user.setEmail(userRequest.getEmail());
	    user.setPhone(userRequest.getPhone());
	    if (userRequest.getAddress() != null) {
	        Address address = new Address();
	        address.setStreet(userRequest.getAddress().getStreet());
	        address.setState(userRequest.getAddress().getState());
	        address.setZipcode(userRequest.getAddress().getZipcode());
	        address.setCity(userRequest.getAddress().getCity());
	        address.setCountry(userRequest.getAddress().getCountry());
	    }
	}
}
/*
 * 🧩 What is @Service?
 * 
 * @Service is a stereotype annotation in Spring used to mark a class as a
 * service provider. It tells Spring that the class contains business logic and
 * should be managed as a Spring bean.
 * 
 * 🧠 How It Works - When Spring scans the application during startup, it
 * detects classes annotated with @Service and registers them in the
 * ApplicationContext. - These classes are then available for dependency
 * injection wherever needed.
 * 
 * 🧱 Role in Application Architecture - Controller Layer: Handles HTTP
 * requests. - Service Layer: Contains business logic and rules. - Repository
 * Layer: Interacts with the database. The @Service annotation helps clearly
 * separate concerns by identifying the business logic layer.
 */



/*
 * 🚀 What Is the Stream API? The Stream API in Java (introduced in Java 8)
 * allows you to process collections (like List, Set) in a functional,
 * declarative style. Instead of writing loops, you chain operations like
 * filter, map, collect, etc. Think of a stream as a pipeline: data flows
 * through a series of transformations and filters.
 * 
 * 🧱 Core Concepts 1. Stream Creation You can create a stream from a
 * collection: List<String> names = Arrays.asList("Yash", "Aryan", "Neha");
 * Stream<String> stream = names.stream();
 * 
 * 
 * 2. Intermediate Operations These transform or filter the stream. Examples: -
 * filter() - map() - sorted() - distinct() 3. Terminal Operations These produce
 * a result or side effect: - collect() - forEach() - count() - reduce()
 * 
 * 🔍 filter() – Select Elements Based on a Condition ✅ What It Does Filters
 * elements using a predicate (a function that returns true or false). 🧠 Syntax
 * stream.filter(element -> condition)
 * 
 * 
 * 🧪 Example List<String> names = Arrays.asList("Yash", "Aryan", "Neha",
 * "Yashwant");
 * 
 * List<String> filtered = names.stream() .filter(name ->
 * name.startsWith("Yash")) .collect(Collectors.toList());
 * 
 * 
 * Result: ["Yash", "Yashwant"]
 * 
 * 🔄 map() – Transform Each Element ✅ What It Does Applies a function to each
 * element and returns a new stream of transformed elements. 🧠 Syntax
 * stream.map(element -> transformation)
 * 
 * 
 * 🧪 Example List<String> names = Arrays.asList("Yash", "Aryan");
 * 
 * List<Integer> nameLengths = names.stream() .map(name -> name.length())
 * .collect(Collectors.toList());
 * 
 * 
 * Result: [4, 5]
 * 
 * 🧠 Predicate<T> – Functional Interface for Conditions ✅ What It Is A
 * functional interface with one method: boolean test(T t);
 * 
 * 
 * Used in filter() to define the condition. 🧪 Example Predicate<String>
 * startsWithY = name -> name.startsWith("Y");
 * 
 * List<String> result = names.stream() .filter(startsWithY)
 * .collect(Collectors.toList());
 * 
 * 
 * You can also combine predicates: Predicate<String> longName = name ->
 * name.length() > 4; Predicate<String> combined = startsWithY.and(longName);
 * 
 * 
 * 
 * 🧰 Putting It All Together 🧪 Real-World Example: Filtering and Updating
 * Users public boolean updateUser(Long id, User updatedUser) { return
 * userList.stream() .filter(user -> user.getId().equals(id)) // find matching
 * user .findFirst() .map(existingUser -> {
 * existingUser.setFirstName(updatedUser.getFirstName());
 * existingUser.setLastName(updatedUser.getLastName()); return true;
 * }).orElse(false); // if not found, return false }
 * 
 * 
 * - filter: narrows down to the user with matching ID - findFirst: gets the
 * first match - map: updates the user and returns true - orElse: fallback if no
 * match is found
 * 
 * 🧠 Bonus: Other Useful Stream Operations | Operation | Purpose | | sorted() |
 * Sorts elements | | distinct() | Removes duplicates | | limit(n) | Limits to
 * first n elements | | skip(n) | Skips first n elements | | collect() |
 * Converts stream to list, set, map, etc. | | reduce() | Combines elements into
 * a single result |
 * 
 * 
 * 
 * 🧠 Summary | Concept | Description | Example | | filter() | Select elements
 * based on condition | filter(x -> x > 10) | | map() | Transform each element |
 * map(x -> x * 2) | | Predicate | Functional interface for conditions |
 * Predicate<String> p = s -> s.isEmpty() |
 */

/*
 * public boolean updateUser(Long id, User updatedUser) { return
 * userList.stream() .filter(user -> user.getID()==id) .findFirst()
 * .map(existingUser -> { existingUser.setFirstname(updatedUser.getFirstname());
 * existingUser.setLastname(updatedUser.getLastname()); return true;
 * }).orElse(false); } }
 */



