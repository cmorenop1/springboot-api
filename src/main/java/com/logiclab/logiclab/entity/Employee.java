package com.logiclab.logiclab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    /**
     * *What was wrong:**
     * The "id" field in the Employee class was missing a way to share its value outside of the class.
     * In programming terms, there was no "getter" method for the "id" field, so when the Employee's
     * information was converted to a format like JSON, the "id" was left out.
     * <p>
     * *How I solved it:**
     * I added a "getter" method for the "id" field in the Employee class.
     * This method allows other parts of the code to access the "id" value.
     * By doing this, when the Employee's information is turned into JSON, the "id" is now included, and it appears in the response.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    public Employee() {
    }

    public int getId() { // Added getter method for 'id'
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

/*

    The solution was important for several reasons:

        1. **Data Integrity:** The "id" field is often a critical piece of information in database entities.
        It's commonly used to uniquely identify a record. Without the "id" being included in the JSON response, consumers of the
        API might not have access to this essential identifier, leading to potential issues in managing or referencing the specific employee record.

        2. **Consistency and Expectation:** Clients consuming the REST API would typically expect all the relevant details of an entity,
        including the "id," to be available in the response. Omitting it could lead to confusion and inconsistency in how the API behaves.

        3. **Ease of Development and Maintenance:** By providing a standardized way to access the "id" (through the getter method),
        the code adheres to common Java practices and conventions. This makes the code easier to understand and
        maintain for other developers who may work on it in the future.

        4. **Enabling Further Operations:** Many operations in a system might depend on the "id" of an entity
        (like updating or deleting a specific employee). By including the "id" in the JSON response, these operations can be carried
         out smoothly, without requiring additional queries or steps to ascertain the "id."

        In summary, the solution ensures that the application behaves as expected, aligns with common coding standards,
         and facilitates further actions that may need to be performed on the employee entity. It's a small change that
          can have a significant impact on the functionality and usability of the system.
*/
