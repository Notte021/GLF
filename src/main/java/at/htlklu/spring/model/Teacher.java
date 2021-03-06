package at.htlklu.spring.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "TEACHER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Teacher extends RepresentationModel<Teacher> implements Serializable
{
	private static final long serialVersionUID = -7790802681322726971L;
	private static final Logger logger = LogManager.getLogger(Teacher.class);
	private static final String className = "Teacher";


	//region Properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)				
	@Column(name = "TEACHER_ID")	
	private Integer teacherId;
	
	@NotBlank														// https://www.baeldung.com/hibernate-validator-constraints, https://www.baeldung.com/javax-validation
	@Length(min = 3, max = 25)
	private String surname;
	@NotBlank
	private String firstname;
	@NotBlank
	@Column(name = "SHORT_NAME")									
	private String shortName;
	@NotNull
	private Character sex;
	private String title;
	@Email 
	private String email;
	private String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher", 								// JPA (mappedBy gibt das Feld in der Klasse "teacher" an)
			   cascade = CascadeType.MERGE, 	
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY)
	private List<SchoolClass> schoolClasses = new ArrayList<SchoolClass>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher", 								// JPA (mappedBy gibt das Feld in der Klasse "teacher" an)
			   cascade = CascadeType.MERGE, 	
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY)
	private List<Department> departments = new ArrayList<Department>();
	//endregion


	//region Constructors
	public Teacher()
	{
//		logger.info(LogUtils.info(className, "Teacher()"));
	}
	
		
	public Teacher(String surname, 
				   String firstname, 
				   String shortName,
				   Character sex, 
				   String title, 
				   String email, 
				   String phone)
	{
		super();
//		logger.info(LogUtils.info(className, "Teacher(sfsstep)"));

		this.surname = surname;
		this.firstname = firstname;
		this.shortName = shortName;
		this.sex = sex;
		this.title = title;
		this.email = email;
		this.phone = phone;
	}
	
	
	public Teacher(String surname, 
				   String firstname, 
				   String shortName,
				   Character sex)
	{
		this(surname, firstname, shortName, sex, null, null, null);
//		logger.info(LogUtils.info(className, "Teacher(sfss)"));
	}
	//endregion


	//region Methods
//	@JsonGetter("toString")
	@Override
	public String toString()
	{
		return String.format("%s %s (%d)", this.surname, this.firstname, this.teacherId);
	}
	//endregion


	//region Getter and Setter
	public Integer getTeacherId()
	{
		return teacherId;
	}
	public void setTeacherId(Integer teacherId)
	{
		this.teacherId = teacherId;
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

	public String getShortName()
	{
		return shortName;
	}
	public void setShortName(String shortName)
	{
		this.shortName = shortName;
	}

	public Character getSex()
	{
		return sex;
	}
	public void setSex(Character sex)
	{
		this.sex = sex;
	}

	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	
	
	public List<SchoolClass> getSchoolClasses()
	{
		return schoolClasses;
	}
	public void setSchoolClasses(List<SchoolClass> schoolClasses)
	{
		this.schoolClasses = schoolClasses;
	}

	public List<Department> getDepartments()
	{
		return departments;
	}
	public void setDepartments(List<Department> departments)
	{
		this.departments = departments;
	}
	//endregion


	//region HashCode and Equals
	@Override
	public int hashCode() {
	    return Objects.hash(surname, firstname);
	}
	
	@Override 
	public boolean equals(Object obj)
	{
		boolean equal;
		Teacher teacher1 = this;
		if (teacher1 == obj) 															// Referenzen gleich?
		{
			equal = true;
		}
		else if ((obj == null) || (teacher1.getClass() != obj.getClass()))			// zweite Ref. null oder andere Klassen
		{
			equal = false;
		}
		else
		{
			Teacher teacher2 = (Teacher)obj;
			equal = Objects.equals(teacher1.teacherId, teacher2.teacherId);
		}
		return equal;
	}
	//endregion
	
}
