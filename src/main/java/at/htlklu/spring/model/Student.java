package at.htlklu.spring.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.hateoas.RepresentationModel;

@Entity																
@Table(name = "STUDENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student extends RepresentationModel<Student> implements Serializable
{
	private static final long serialVersionUID = -6574326723164905323L;


	//region Properties
	@Id																
	@GeneratedValue(strategy = GenerationType.IDENTITY)				
	@Column(name = "STUDENT_ID")		
	private Integer studentId;

	@ManyToOne(fetch = FetchType.LAZY)								
    @JoinColumn(name = "SCHOOLCLASS_ID")							
	private SchoolClass schoolClass;

	@JsonIgnore
	@OneToMany(mappedBy = "student", 								
			   cascade = CascadeType.MERGE, 	
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY)
	private List<Address> addresses = new ArrayList<Address>();

	@JsonIgnore
	@OneToMany(mappedBy = "student", 								
			   cascade = CascadeType.MERGE, 	
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY)
	private List<StudentSubject> studentSubjects = new ArrayList<StudentSubject>();
		
	private String surname;
	private String firstname;
	private char sex;
	@Column(name = "BIRTHDATE")
	private LocalDate birthDate;
	private Integer height;	
	private Double weight;
	//endregion


	//region Constructors
	public Student()
	{
	}	
		
	public Student(SchoolClass schoolClass,
				   String surname, 
				   String firstname, 
				   char sex, 
				   LocalDate birthDate, 
				   Integer height, 
				   Double weight)
	{
		super();
		this.surname = surname;
		this.firstname = firstname;
		this.sex = sex;
		this.birthDate = birthDate;
		this.height = height;
		this.weight = weight;
		
		this.schoolClass = schoolClass;					// unidirektionale Verknüpfung
		this.schoolClass.getStudents().add(this);		// unidirektionale Verknüpfung 	-> 	bidirektionale Verknüpfung
	}
	//endregion


	//region Methods
	@JsonGetter("toString")
	@Override
	public String toString()
	{
		return String.format("%1$s %2$s", this.surname, this.firstname);
	}
	//endregion


	//region Getter and Setter
	public Integer getStudentId()
	{
		return studentId;
	}
	public void setStudentId(Integer studentId)
	{
		this.studentId = studentId;
	}

	public String getSurname()
	{
		return surname;
	}
	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public char getSex()
	{
		return sex;
	}
	public void setSex(char sex)
	{
		this.sex = sex;
	}

	public LocalDate getBirthDate()
	{
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate)
	{
		this.birthDate = birthDate;
	}

	public Integer getHeight()
	{
		return height;
	}
	public void setHeight(Integer height)
	{
		this.height = height;
	}

	public Double getWeight()
	{
		return weight;
	}
	public void setWeight(Double weight)
	{
		this.weight = weight;
	}


	public SchoolClass getSchoolClass()
	{
		return schoolClass;
	}	
	public void setSchoolClass(SchoolClass schoolClass)
	{
		this.schoolClass = schoolClass;
	}

	public List<StudentSubject> getStudentSubjects()
	{
		return studentSubjects;
	}
	public void setStudentSubjects(List<StudentSubject> studentSubjects)
	{
		this.studentSubjects = studentSubjects;
	}
	
	public List<Address> getAddresses()
	{
		return addresses;
	}
	public void setAddresses(List<Address> addresses)
	{
		this.addresses = addresses;
	}
	//endregion
	
}
