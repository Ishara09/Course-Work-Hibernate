package Entity;

import javax.persistence.*;

@Entity
public class RegistrationEntity {
        @Id
        private String regNo;
        private String date;
        private String regFee;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "cID",referencedColumnName = "code",nullable = false)
        private CourseEntity course;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "sID",referencedColumnName = "id",nullable = false)
        private StudentEntity student;

    public RegistrationEntity(String regNo, String date, String regFee, CourseEntity course, StudentEntity student) {
        this.regNo = regNo;
        this.date = date;
        this.regFee = regFee;
        this.course = course;
        this.student = student;
    }


        public RegistrationEntity() {
        }

        public String getRegNo() {
            return regNo;
        }

        public void setRegNo(String regNo) {
            this.regNo = regNo;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getRegFee() {
            return regFee;
        }

        public void setRegFee(String regFee) {
            this.regFee = regFee;
        }

        public CourseEntity getCourse() {
            return course;
        }

        public void setCourse(CourseEntity course) {
            this.course = course;
        }

        public StudentEntity getStudent() {
            return student;
        }

        public void setStudent(StudentEntity student) {
            this.student = student;
        }

        @Override
        public String toString() {
            return "Registration{" +
                    "regNo=" + regNo +
                    ", date=" + date +
                    ", regFee=" + regFee +
                    ", course=" + course +
                    ", student=" + student +
                    '}';
        }
    }

