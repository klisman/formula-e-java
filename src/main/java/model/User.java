package model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@SuppressWarnings("serial")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String password;
	private String email;
	private Boolean active;
	//private Enum Role;
	private Integer age;
}
