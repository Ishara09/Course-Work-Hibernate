package DTO;

public class RegistrationDTO {

    private String regNo;
    private String date;
    private String regFee;

    CourseDTO course;
    StudentDTO student;

    public RegistrationDTO(String regNo, String date, String regFee, CourseDTO course, StudentDTO student) {
        this.regNo = regNo;
        this.date = date;
        this.regFee = regFee;
        this.course = course;
        this.student = student;
    }

    

    public RegistrationDTO() {
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

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
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