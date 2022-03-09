package com.backend_kursus.biludlejning.customer;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
    private String pass;
    private int points;
    //private String fullName = firstName + " " + lastName;
//
//    public Customer(String firstName, String lastName, int id, String email, Date dob, String pass, int points) {
//        this.first_name = firstName;
//        this.last_name = lastName;
//        this.id = id;
//        this.email = email;
//        this.dob = dob;
//        this.pass = pass;
//        this.points = points;
//    }
//
//    public String getFirstName() {
//        return first_name;
//    }
//
//    public void setFirstName(String firstName) {
//        this.first_name = firstName;
//    }
//
//    public String getLastName() {
//        return last_name;
//    }
//
//    public void setLastName(String lastName) {
//        this.last_name = lastName;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Date getDob() {
//        return dob;
//    }
//
//    public void setDob(Date dob) {
//        this.dob = dob;
//    }
//
//    public String getPass() {
//        return pass;
//    }
//
//    public void setPass(String pass) {
//        this.pass = pass;
//    }
//
//    public int getPoints() {
//        return points;
//    }
//
//    public void setPoints(int points) {
//        this.points = points;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "firstName='" + first_name + '\'' +
//                ", lastName='" + last_name + '\'' +
//                ", id=" + id +
//                ", email='" + email + '\'' +
//                ", dob=" + dob +
//                ", pass='" + pass + '\'' +
//                ", points=" + points +
//                '}';
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Customer customer = (Customer) o;
//        return id != null && Objects.equals(id, customer.id);
//    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

