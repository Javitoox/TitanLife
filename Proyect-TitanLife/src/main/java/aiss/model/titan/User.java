package aiss.model.titan;

import java.io.Serializable;
import java.util.List;

import aiss.model.strava.StravaActivityC;
import aiss.model.strava.StravaActivityG;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
    private String email;
    private String password;
    private String retype;
    private DataBMI datosBMI;
    private List<Objetivo> objetivos;
    private String imc;
    private String pesoObj;
    private String imcObj;
    private String fechaObj;
    private List<StravaActivityC> actividades;

    //Cuando se registre un usuario, pondremos los campos se generarán más tarde a null hasta que sean seleccionados
    public User(Integer id,String username, String email, String password, String retype, String age,
    		String height, String weight, String hip, String waist, String sex) {
    	this.id=id;
        this.username=username;
        this.email=email;
        this.password=password;
        this.retype=retype;
        this.objetivos=null;
        this.imc=null;
        this.pesoObj=null;
        this.imcObj=null;
        this.fechaObj=null;
        this.actividades=null;
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
	
	public String getImc() {
		return imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}
	
	@Override
	public String toString() {
		return username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public String getPesoObj() {
		return pesoObj;
	}

	public void setPesoObj(String pesoObj) {
		this.pesoObj = pesoObj;
	}

	public String getImcObj() {
		return imcObj;
	}

	public void setImcObj(String imcObj) {
		this.imcObj = imcObj;
	}

	public String getFechaObj() {
		return fechaObj;
	}

	public void setFechaObj(String fechaObj) {
		this.fechaObj = fechaObj;
	}

	public List<StravaActivityC> getActividades() {
		return actividades;
	}

	public void setActividades(List<StravaActivityC> actividades) {
		this.actividades = actividades;
	}

}