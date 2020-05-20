package aiss.model.titan;

public class Comida {
	private Integer id;
	private String nombre;
	private String caloriasPor100;
	private String descripcion;
	
	public Comida() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCaloriasPor100() {
		return caloriasPor100;
	}

	public void setCaloriasPor100(String caloriasPor100) {
		this.caloriasPor100 = caloriasPor100;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
