package at.htlklu.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.hateoas.RepresentationModel;

@Entity																
@Table(name = "STUDENT_SUBJECT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentSubject extends RepresentationModel<StudentSubject> implements Serializable
{
	private static final long serialVersionUID = -6283415825230759166L;

	//region Properties
	@Id																
	@GeneratedValue(strategy = GenerationType.IDENTITY)				
	@Column(name = "STUDENT_SUBJECT_ID")							
	private Integer studentSubjectId;

	@ManyToOne(fetch = FetchType.LAZY)								
    @JoinColumn(name = "STUDENT_ID")								
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)								
    @JoinColumn(name = "SUBJECT_ID")								
	private Subject subject;
	
	private int grade;
	//endregion


	//region Constructors
	public StudentSubject()
	{
	}
	
	public StudentSubject(Integer studentSubjectId, 
						  int studentId, 
						  int subjectId, 
						  int grade)
	{
		super();
		this.studentSubjectId = studentSubjectId;
		this.grade = grade;
	}
	
	public StudentSubject(int studentId, 
						  int subjectId, 
						  int grade)
	{
		this(null, studentId, subjectId, grade);
	}
	//endregion



	//region Methods
	@Override
	public String toString()
	{
		return String.format("%s", this.grade);
	}
	//endregion


	//region Getter and Setter
	public Integer getStudentSubjectId()
	{
		return studentSubjectId;
	}
	public void setStudentSubjectId(Integer studentSubjectId)
	{
		this.studentSubjectId = studentSubjectId;
	}

	public int getGrade()
	{
		return grade;
	}
	public void setGrade(int grade)
	{
		this.grade = grade;
	}


	public Student getStudent()
	{
		return this.student;
	}
	public void setStudent(Student student)
	{
		this.student = student;
	}

	public Subject getSubject()
	{
		return this.subject;
	}
	public void setSubject(Subject subject)
	{
		this.subject = subject;
	}
	//endregion

}
