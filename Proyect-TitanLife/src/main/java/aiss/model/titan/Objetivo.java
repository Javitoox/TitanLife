package aiss.model.titan;

public class Objetivo {
	private String nombre;
	private TipoDesgasteCalorico tipo;
	
	public Objetivo (String nombre, TipoDesgasteCalorico tipo) {
		this.nombre=nombre;
		this.tipo=tipo;
	}
	
	public TipoDesgasteCalorico getTipo() {
		return tipo;
	}
	public void setTipo(TipoDesgasteCalorico tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
