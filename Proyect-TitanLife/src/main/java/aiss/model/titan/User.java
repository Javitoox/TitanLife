package aiss.model.titan;

public class User {
	
	private String username;
    private String email;
    private String password;
    private String retype;
    private Integer age;
    private Double height;
    private Double weight;
    private Double hip;
    private Double waist;

    public User(String username, String email, String password, String retype, Integer age, Double height, Double weight, Double hip, Double waist) {
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHip() {
        return hip;
    }

    public void setHip(Double hip) {
        this.hip = hip;
    }

    public Double getWaist() {
        return waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }
}