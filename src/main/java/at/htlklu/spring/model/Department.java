package at.htlklu.spring.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.*;

@Entity																
@Table(name = "DEPARTMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department extends RepresentationModel<Department> implements Serializable
{
	private static final long serialVersionUID = -6936296833789537850L;


	//region Properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)				
	@Column(name = "DEPARTMENT_ID")									
	private Integer departmentId;

	@JsonProperty("head")
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")								
	private Teacher teacher;
		
	@NotBlank	
	@Column(name = "NAME")											
	private String name;
	@NotBlank	
	@Column(name = "NAME_SHORT")									
	private String nameShort;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department",  							// JPA (mappedBy gibt das Feld in der Klasse "SchoolClass" an)
			   cascade = CascadeType.MERGE,
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY)
	@OrderBy("level")												// JPA (Sortierung nach dem Level)
	private List<SchoolClass> schoolClasses = new ArrayList<SchoolClass>();
	//endregion


	//region Constructors
	public Department()
	{
	}
	
	
	public Department(String name, 
					  String nameShort, 
					  Teacher teacher)
	{
		super();
		this.name = name;
		this.nameShort = nameShort;
		this.teacher = teacher;
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
	public Integer getDepartmentId()
	{
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId)
	{
		this.departmentId = departmentId;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getNameShort()
	{
		return nameShort;
	}
	public void setNameShort(String nameShort)
	{
		this.nameShort = nameShort;
	}

	
	
	public Teacher getTeacher()
	{
		return teacher;
	}
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
		

	public List<SchoolClass> getSchoolClasses()
	{
		return schoolClasses;
	}
	//endregion


	//region HashCode and Equals
	@Override
	public int hashCode() {
	    return Objects.hash(name);
	}
	
	@Override 
	public boolean equals(Object obj)
	{
		boolean equal;
		Department department1 = this;
		if (department1 == obj) 															// Referenzen gleich?
		{
			equal = true;
		}
		else if ((obj == null) || (department1.getClass() != obj.getClass()))			// zweite Ref. null oder andere Klassen
		{
			equal = false;
		}
		else
		{
			Department department2 = (Department)obj;
			equal = Objects.equals(department1.departmentId, department2.departmentId);
		}
		return equal;
	}
	//endregion
	
}
