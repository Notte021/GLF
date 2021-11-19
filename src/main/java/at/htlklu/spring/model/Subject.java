package at.htlklu.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.hateoas.RepresentationModel;

@Entity																
@Table(name = "SUBJECT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Subject extends RepresentationModel<Subject> implements Serializable
{
	private static final long serialVersionUID = -4570495411166636654L;

	//region Properties
	@Id																
	@GeneratedValue(strategy = GenerationType.IDENTITY)				
	@Column(name = "SUBJECT_ID")									
	private Integer subjectId;
	@NotBlank
	private String name;
	@NotBlank
	@Column(name = "NAME_SHORT")									
	private String nameShort;
	private boolean main;

	@JsonIgnore
	@OneToMany(mappedBy = "subject", 						
			   cascade = CascadeType.MERGE, 	
			   orphanRemoval = true, 
			   fetch = FetchType.LAZY)
	private List<StudentSubject> studentSubjects = new ArrayList<StudentSubject>();
	//endregion


	//region Constructors
	public Subject()
	{	
	}
	
	public Subject(Integer subjectId, 
				   String name, 
				   String nameShort, 
				   boolean main)
	{
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.nameShort = nameShort;
		this.main = main;
	}
	
	public Subject(String name, 
				   String nameShort, 
				   boolean main)
	{
		this(null, name, nameShort, main);
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
	public Integer getSubjectId()
	{
		return subjectId;
	}
	public void setSubjectId(Integer subjectId)
	{
		this.subjectId = subjectId;
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

	public boolean getMain()
	{
		return main;
	}
	public void setMain(boolean main)
	{
		this.main = main;
	}


	public List<StudentSubject> getStudentSubjects()
	{
		return this.studentSubjects;
	}
	public void setStudentSubjects(List<StudentSubject> studentSubjects)
	{
		this.studentSubjects = studentSubjects;
	}
	//endregion

}
