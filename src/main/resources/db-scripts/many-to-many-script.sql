
CREATE TABLE student(
    id VARCHAR(10) PRIMARY KEY ,
    name VARCHAR(250) NOT NULL ,
    address VARCHAR(500),
    contact VARCHAR(15) NOT NULL ,
    dob DATE NOT NULL
);

CREATE TABLE course(
    code VARCHAR(10) PRIMARY KEY ,
    name VARCHAR(250) NOT NULL ,
    duration VARCHAR(20) NOT NULL
);

#Student
    /*
    studentId S001 - 10 -pk
    name 250 not null
    address 500 -
    contact 15 not null + unique
    dob date - unique

    courses

    code 10  pk
    name 100 not null
    duration 20 not null

    student_courses

    student_id 10 fk
    course_code 10  fk
    date date not null
    registerdby 30 not null

    */


CREATE TABLE student_course(
  student_id VARCHAR(10) NOT NULL ,
  course_code VARCHAR(10) NOT NULL ,
  date DATE NOT NULL,
  registered_by VARCHAR(30) NOT NULL ,
  CONSTRAINT pk_student_course PRIMARY KEY (student_id, course_code),
  CONSTRAINT fk_order FOREIGN KEY (student_id) REFERENCES student(id),
  CONSTRAINT fk_item FOREIGN KEY (course_code) REFERENCES course (code)
);