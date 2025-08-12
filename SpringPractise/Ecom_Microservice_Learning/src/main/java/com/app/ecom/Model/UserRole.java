package com.app.ecom.Model;

public enum UserRole {
	CUSTOMER,ADMIN

}

/*
 * 🧭 What Is an enum? An enum (short for enumeration) is a special data type in
 * Java used to define a fixed set of constants. It’s ideal for representing
 * values that don’t change—like status codes, roles, directions, or categories.
 * 
 * 🧠 Why Use enum? - Type safety: Prevents invalid values (e.g., no accidental
 * "ACTIVEE" typo). - Readability: Makes code more expressive and
 * self-documenting. - Maintainability: Centralizes constant values in one
 * place. - Functionality: Can include fields, methods, and constructors.
 * 
 * 🔍 Key Characteristics | Feature | Description | | Fixed set of values |
 * Defined at compile time (e.g., ACTIVE, INACTIVE) | | Type-safe | Only valid
 * enum values can be used | | Can have fields/methods | Enums can behave like
 * full-fledged classes | | Used in switch/case | Clean branching logic based on
 * enum values |
 * 
 * 
 * 
 * 🛠 Common Use Cases - Status indicators: OrderStatus { PENDING, SHIPPED,
 * DELIVERED } - User roles: Role { ADMIN, USER, GUEST } - Days of the week: Day
 * { MONDAY, TUESDAY, ... } - Error codes or states: ErrorType {
 * VALIDATION_ERROR, SYSTEM_ERROR }
 * 
 * 🔄 Enum vs. Constants | Aspect | enum | static final constants | | Type
 * safety | ✅ Yes | ❌ No | | Grouping | ✅ Logical grouping | ❌ Scattered across
 * classes | | Extendable | ✅ Can have methods/fields | ❌ Just values | |
 * Readability | ✅ Clear and expressive | ❌ Often cryptic |
 */




