package aiss.model;

public class User {
	
	private String username;
	private String email;
	private String password;
	private String retype;
	private Integer age;
	private Integer height;
	private Integer weight;
	private Integer hip;
	private Integer waist;
	
	public User(String username, String email, String password, String retype, Integer age, Integer height, Integer weight, Integer hip, Integer waist) {
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

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHip() {
		return hip;
	}

	public void setHip(Integer hip) {
		this.hip = hip;
	}

	public Integer getWaist() {
		return waist;
	}

	public void setWaist(Integer waist) {
		this.waist = waist;
	}
	
}