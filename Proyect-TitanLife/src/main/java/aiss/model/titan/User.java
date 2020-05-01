package aiss.model.titan;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
    private String email;
    private String password;
    private String retype;
    private DataBMI datosBMI;
    private List<Objetivo> objetivos;

    //Cuando se registre un usuario, pondremos los objetivos a null hasta que más adelante sean seleccionados
    public User(Integer id,String username, String email, String password, String retype, String age,
    		String height, String weight, String hip, String waist, String sex) {
    	this.id=id;
        this.username=username;
        this.email=email;
        this.password=password;
        this.retype=retype;
        this.objetivos=null;
        DataBMI datos=new DataBMI();
        datos.setAge(age);
        Height altura=new Height();
        altura.setValue(height);
        altura.setUnit("cm");
        datos.setHeight(altura);
        Weight peso=new Weight();
        peso.setValue(weight);
        peso.setUnit("kg");
        datos.setWeight(peso);
        datos.setHip(hip);
        datos.setWaist(waist);
        datos.setSex(sex);
        this.datosBMI=datos;
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

	public DataBMI getDatosBMI() {
		return datosBMI;
	}

	public void setDatosBMI(DataBMI datosBMI) {
		this.datosBMI = datosBMI;
	}

	public List<Objetivo> getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}

	public Integer getId() {
		return id;
	}

}