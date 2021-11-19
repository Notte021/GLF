package at.htlklu.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.*;

@Entity																
@Table(name = "SCHOOLCLASS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SchoolClass extends RepresentationModel<SchoolClass> implements Serializable
{
	private static final long serialVersionUID = 6319534678615031709L;


	//region Properties
	@Id																
	@GeneratedValue(strategy = GenerationType.IDENTITY)				
	@Column(name = "SCHOOLCLASS_ID")				
	private Integer schoolClassId;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)								
    @JoinColumn(name = "DEPARTMENT_ID")								
	private Department department;
			
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)								
    @JoinColumn(name = "TEACHER_ID")								
	private Teacher teacher;
	
	@NotBlank	
	private String name;
	@Min(value = 9)
    @Max(value = 13)
	private int level;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "schoolClass", 							// JPA (mappedBy gibt das Feld in der Klasse "Student" an)
			   cascade = CascadeType.MERGE, 	
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY)
	private List<Student> students = new ArrayList<Student>();
	//endregion


	//region Constructors
	public SchoolClass()
	{
	}
	
	public SchoolClass(String name, 
					   int level,
					   String description)
	{
		super();
		this.name = name;
		this.level = level;
		this.description = description;
	}
	//endregion


	//region Methods
	@Override
	public String toString()
	{
		return String.format("%s", this.name);
	}
	//endregion


	//region Getter and Setter
	public Integer getSchoolClassId()
	{
		return schoolClassId;
	}
	public void setSchoolClassId(Integer schoolClassId)
	{
		this.schoolClassId = schoolClassId;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}

	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}

	
	public Department getDepartment()
	{
		return department;
	}
	public void setDepartment(Department department)
	{
		this.department = department;
	}
	
	public Teacher getTeacher()
	{
		return teacher;
	}
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}

	public List<Student> getStudents()
	{
		return students;
	}
	//endregion
	
}
