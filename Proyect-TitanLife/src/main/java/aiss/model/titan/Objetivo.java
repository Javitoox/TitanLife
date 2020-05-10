package aiss.model.titan;

import java.io.Serializable;

public class Objetivo implements Serializable , Comparable<Objetivo>{
	private static final long serialVersionUID = 1L;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Objetivo other = (Objetivo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public int compareTo(Objetivo o) {
		// TODO Auto-generated method stub
		return nombre.compareTo(o.getNombre());
	}

	@Override
	public String toString() {
		return  nombre;
	}
	
	
}
