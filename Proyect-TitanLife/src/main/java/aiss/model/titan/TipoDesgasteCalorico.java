package aiss.model.titan;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public enum TipoDesgasteCalorico {
	ALTO,BAJO,MEDIO;
}
