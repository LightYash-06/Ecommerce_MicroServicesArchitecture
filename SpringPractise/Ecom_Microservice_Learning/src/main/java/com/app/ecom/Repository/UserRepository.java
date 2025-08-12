package com.app.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecom.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

/*
 * 🏷️ What is @Repository?
 * 
 * @Repository is a Spring stereotype annotation used to mark a class as a Data
 * Access Object (DAO). It tells Spring that the class is responsible for
 * interacting with the database.
 * 
 * 🧠 How It Works - Spring detects classes annotated with @Repository during
 * component scanning and registers them as beans. - It also enables exception
 * translation—converting low-level persistence exceptions (like SQLException)
 * into Spring’s unified DataAccessException
 */


/*
 * 📚 What is JpaRepository? JpaRepository is a Spring Data interface that
 * provides a rich set of built-in CRUD operations and query methods for working
 * with JPA entities.
 * 
 * 🧠 How It Works - You define an interface that extends
 * JpaRepository<EntityType, IDType>. - Spring automatically generates the
 * implementation at runtime. - You get methods like save(), findById(),
 * delete(), and more—without writing any SQL or JPQL.
 */


/*
 * 🔍 Key Features of JpaRepository | Method | Purpose | | save(entity) | Insert
 * or update an entity | | findById(id) | Retrieve an entity by primary key | |
 * findAll() | Get all entities | | deleteById(id) | Delete an entity by ID | |
 * existsById(id) | Check if an entity exists | | count() | Count total entities
 * |
 */

/*
 * 🧱 What Are JPA Mappings? JPA (Java Persistence API) mappings define how Java
 * objects (entities) relate to database tables and how relationships between
 * entities are represented.
 * 
 * 🔗 Core Relationship Annotations 1. @OneToOne - Represents a one-to-one
 * relationship between two entities. - Example: A User has one Profile.
 * 2. @OneToMany - One entity is related to many others. - Example: A User has
 * many Orders. 3. @ManyToOne - Many entities relate to one. - Example: Many
 * Orders belong to one User. 4. @ManyToMany - Many entities relate to many
 * others. - Example: A Student enrolled in many Courses, and each Course has
 * many Students.
 * 
 * 🧭 What is @JoinColumn?
 * 
 * @JoinColumn is used to specify the foreign key column in a relationship. 🔍
 * Key Attributes | Attribute | Purpose | | name | Name of the foreign key
 * column | | referencedColumnName | Column in the target entity being
 * referenced | | nullable | Whether the foreign key can be null | | unique |
 * Whether the foreign key must be unique |
 * 
 * 
 * 🧠 Example Use Case In a @ManyToOne relationship from Order to
 * User, @JoinColumn(name = "user_id") tells JPA to use user_id as the foreign
 * key in the Order table.
 * 
 * 🔄 What is cascade? cascade defines how operations on one entity affect its
 * related entities. 🔍 Cascade Types | Cascade Type | Description | | PERSIST |
 * Saves the child when the parent is saved | | MERGE | Updates the child when
 * the parent is updated | | REMOVE | Deletes the child when the parent is
 * deleted | | REFRESH | Refreshes the child when the parent is refreshed | |
 * DETACH | Detaches the child when the parent is detached | | ALL | Applies all
 * of the above |
 * 
 * 
 * 🧠 Example Use Case If a User has a list of Orders, and you want to save all
 * orders when saving the user, use cascade = CascadeType.PERSIST.
 * 
 * 🧠 Fetch Types | Fetch Type | Description | | LAZY | Loads related entities
 * only when accessed | | EAGER | Loads related entities immediately with the
 * parent |
 * 
 * 
 * Use LAZY for performance unless you truly need the related data upfront.
 * 
 * 🛠 Common Mapping Patterns 🔹 @OneToMany with @JoinColumn - Used when the
 * child table holds the foreign key. - Avoids creating a join table.
 * 🔹 @ManyToMany with @JoinTable - Defines a third table to hold associations.
 * 🔹 Bidirectional Relationships - Both entities reference each other. - Use
 * mappedBy to avoid duplicate foreign keys.
 * 
 * ⚠️ Things to Watch Out For - Always choose LAZY fetch unless eager loading is
 * necessary. - Be cautious with CascadeType.REMOVE—it can delete child records
 * unintentionally. - Use mappedBy correctly to avoid infinite loops in
 * bidirectional relationships. - Prefer EnumType.STRING for enum fields to
 * avoid fragile ordinal mapping.
 * 
 * Would you like help designing a clean entity relationship for User, Order,
 * and Product with proper mappings and cascade settings?
 */



