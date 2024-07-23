package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourseEnrollment implements Serializable {

    @EmbeddedId
    private StudentCoursePK studentCoursePK;

    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id", insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_code",referencedColumnName = "code",insertable = false,updatable = false)
    private Course course;

    public StudentCourseEnrollment(Student student, Course course,String registeredBy, Date date) {
        this.studentCoursePK = new StudentCoursePK(student.getStudentId(),course.getCourseCode());
        this.registeredBy = registeredBy;
        this.date = date;
        this.student = student;
        this.course = course;
    }
}
