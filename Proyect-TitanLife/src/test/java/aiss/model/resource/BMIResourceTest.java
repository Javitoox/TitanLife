package aiss.model.resource;

import static org.junit.Assert.assertNotNull;

import org.junit.*;

import aiss.model.BMI.BMIResult;
import aiss.model.resource.BMIResource;
import aiss.model.titan.DataBMI;
import aiss.model.titan.Height;
import aiss.model.titan.Weight;

public class BMIResourceTest {
	
//	private static UserRepository repository;
	static BMIResult BMI1, BMI2, BMI3;
	static BMIResource br = new BMIResource();
	
	@BeforeClass
	public static void setup() throws Exception {
		
		
	}

	@SuppressWarnings("static-access")

	@Test
	public void testgetBMI() {
		
		DataBMI dataBMI = new DataBMI();
		Height height = new Height();
		Weight weight = new Weight();
		height.setValue("170.00");
		height.setUnit("cm");
		weight.setValue("60.00");
		weight.setUnit("kg");

		dataBMI.setAge("19");
		dataBMI.setHeight(height);
		dataBMI.setHip("80.00");
		dataBMI.setWaist("80.00");
		dataBMI.setSex("m");
		dataBMI.setWeight(weight);
		
		
		BMI3 = br.getBMI(dataBMI);
		
		assertNotNull("Error when getting the BMIResult", BMI3);
		
		System.out.println(BMI3);
	}
}
