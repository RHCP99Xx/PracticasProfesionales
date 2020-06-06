package pojo;


public class StudentPojo extends UserPojo{
    private String enrollment;
    private String phone;
    
    public StudentPojo(){
        
    }
    

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String studentEnrollment) {
        this.enrollment = studentEnrollment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String studentPhone) {
        this.phone = studentPhone;
    }
}
