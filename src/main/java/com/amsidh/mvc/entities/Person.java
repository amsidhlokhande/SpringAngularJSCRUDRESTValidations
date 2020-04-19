package com.amsidh.mvc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name="person.paginated.query", query="SELECT * FROM Person ORDER BY :sortFields",resultClass=Person.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3756046565760756872L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    @SequenceGenerator(name = "id", sequenceName = "id")
	private Long id;
	private String name;
	private String description;
	private String imageUrl;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(Long id, String name, String description,String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl=imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Person person = (Person) o;

        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
