package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(name = "id")
    private String studentId;
    private String name;
    private String address;
    private String contact;
    private Date dob;

    @Transient
    private int age;

    public Student(String id, String firstName,String lastName, String address, String contact, Date dob, int age) {
        this.studentId = id;
        this.name = firstName + " " + lastName;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.age = age;
    }
}
