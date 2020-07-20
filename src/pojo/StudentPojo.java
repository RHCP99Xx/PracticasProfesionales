package pojo;

public class StudentPojo extends UserPojo{
    private String enrollment;
    private String phone;
    
    public StudentPojo(){
        
    }
    
    /**
     * 
     * @return 
     */
    public String getEnrollment() {
        return enrollment;
    }
    /**
     * 
     * @param studentEnrollment 
     */
    public void setEnrollment(String studentEnrollment) {
        this.enrollment = studentEnrollment;
    }
    /**
     * 
     * @return 
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 
     * @param studentPhone 
     */
    public void setPhone(String studentPhone) {
        this.phone = studentPhone;
    }
}
