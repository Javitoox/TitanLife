package aiis.model.resource;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import com.fatsecret.platform.model.Food;

import aiss.model.resource.FatSecretResource;

import com.fatsecret.platform.model.CompactFood;


public class FatSecretReourceTest {
	static Food F1;
	static List<CompactFood> LCF1;
	static FatSecretResource fsr = new FatSecretResource();

	
	
	@SuppressWarnings("static-access")
	@Test
	public void testListCompactFood() {
		
		LCF1=fsr.searchFood("Pollo");
		
		assertNotNull("Error when searching a food", LCF1);
		System.out.println("Lista de comidas con: "+ "Pollo");
		for(Integer i =0;i<LCF1.size();i++) {	
		System.out.println("Food "  +i+ " : " + LCF1.get(i).getName().toString() + " (ID=" + LCF1.get(i).getId().toString() + ")");
				}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testgetFood() {
		Long id = (long) 1009433;
		F1=fsr.detaliedFood(id);
		
		assertNotNull("Error when searching a food by its ID", F1);
		
		System.out.println("Food" + " : "  +F1.getName().toString()+ " (ID=" + F1.getId().toString()+")");
	}
}
