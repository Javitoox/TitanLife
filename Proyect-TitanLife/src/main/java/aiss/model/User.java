package aiss.model;

public class User {
	
	private String username;
	private String email;
	private String password;
	private String retype;
	private Integer age;
	private Float height;
	private Float weight;
	private Float hip;
	private Float waist;
	
	public User(String username, String email, String password, String retype, Integer age, Float height, Float weight, Float hip, Float waist) {
		this.username=username;
		this.email=email;
		this.password=password;
		this.retype=retype;
		this.age=age;
		this.height=height;
		this.weight=weight;
		this.hip=hip;
		this.waist=waist;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetype() {
		return retype;
	}

	public void setRetype(String retype) {
		this.retype = retype;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHip() {
		return hip;
	}

	public void setHip(Float hip) {
		this.hip = hip;
	}

	public Float getWaist() {
		return waist;
	}

	public void setWaist(Float waist) {
		this.waist = waist;
	}
	
}