package pojo;

import java.util.Date;

public class ParticipationPojo {
    
    private int block;
    private Date finalDate;
    private Date initialDate;
    private String nrc;
    private String period;
    private int section;
    private StudentPojo student;
    private ProjectPojo project;
    private LinkedOrganizationPojo organization;
    
    public ParticipationPojo(StudentPojo student, ProjectPojo project, LinkedOrganizationPojo organization){
        this.student=student;
        this.project=project;
        this.organization=organization;
    }
    
    public ProjectPojo getProject(){
        return this.project;
    }
    
    public StudentPojo getStudent(){
        return this.student;
    }
    public LinkedOrganizationPojo getOrganization(){
        return this.organization;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }
}
