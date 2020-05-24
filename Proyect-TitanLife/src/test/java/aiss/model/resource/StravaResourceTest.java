//package aiss.model.resource;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import aiss.model.strava.StravaActivity;
//import aiss.model.strava.StravaActivityC;
//import aiss.model.strava.StravaActivityG;
//import aiss.model.strava.StravaToken;
//import aiss.utility.StravaUtility;
//
//public class StravaResourceTest {
	
//	static String access_token="be170c239c536ff48aaa026f5238eb27ef3cacbb";
//	static String code="4c92e736c78cc9a40f387fdde9e85b0bab3a1fab";
//	static StravaActivity sa1,sa2,sa3 =new StravaActivity();
//	static StravaActivityG[] sg1;
//	static StravaActivityC sc1 = new StravaActivityC();
//	static StravaToken st1;
//	static StravaResource sr = new StravaResource(access_token);


	
//	@BeforeClass
//	public static void setup() throws Exception {
//		
////		// Test activity 1
//		sa1 = sr.postStravaRoute("Test1", "Run", StravaUtility.fromISO8601UTC(), Integer.valueOf("3600"), "Test", 
//				Float.valueOf("22222"),access_token);
//		System.out.println(sa1.getName().toString());
//
//	}
//	@Test
//	public void testPostStravaActicity() {
//		
//		String name = "Test3";
//		String type = "Run";
//		String elapsed_time = "3600";
//		String description = "Test";
//		String distance="22222";
//		
//		sa3 = sr.postStravaRoute(name, type, StravaUtility.fromISO8601UTC(), Integer.valueOf(elapsed_time), description, 
//				Float.valueOf(distance),access_token);
//		
//		assertNotNull("The activity has been post correctly", sa3);
//		System.out.println(sa3.getName());
//		
//		assertEquals("The activity's name has not been setted correctly", name, sa3.getName().toString());
//		assertEquals("The activity's type has not been setted correctly", type, sa3.getType().toString());
//		assertEquals("The activity's elapsed_time has not been setted correctly", elapsed_time, sa3.getElapsedTime().toString());
//		assertEquals("The activity's description has not been setted correctly", description, sa3.getDescription().toString());
//		assertEquals("The activity's distance has not been setted correctly", distance, sa3.getDistance().toString());
//
//
//	}
//
//	
//
//@Test
//public void testUpdateStravaActicity() {
//		
//		String name = "Tesi";
//		String type = "Run";
//		String elapsed_time = "3600";
//		String description = "Test";
//		String distance="22222";
//		
//		sa1.setName(name);
//		sa1.setType(type);
//		sa1.setElapsedTime(Integer.valueOf(elapsed_time));
//		sa1.setDescription(description);
//		sa1.setDistance(Integer.valueOf(distance));
//
//		sc1=sr.uploadStravaActivityC(sa1.getId().toString(),sa1);
//
//		assertNotNull("Error when updating the activity", sc1);
//		
//		System.out.println(sc1.getName());
//		
//		
//		
//		assertEquals("The activity's name has not been setted correctly", name, sa1.getName().toString());
//		assertEquals("The activity's type has not been setted correctly", type, sa1.getType().toString());
//		assertEquals("The activity's elapsed_time has not been setted correctly", elapsed_time, sa1.getElapsedTime().toString());
//		assertEquals("The activity's description has not been setted correctly", description, sa1.getDescription().toString());
//		assertEquals("The activity's distance has not been setted correctly", distance, sa1.getDistance().toString());
//
//
//
//	}
//
//@Test
//public void testgetStravaActicityC() {
//	
//	StravaActivityG[] sag = sr.getStravaActivity();
//
//	sc1 = sr.getStravaActivityC(sag[0].getId().toString());
//	
//	assertNotNull("Error when getting the activity", sc1);
//	
//	System.out.println(sc1.getName().toString());
//	
//			
//}
//@Test
//public void testgetStravaActicityG() {
//	
//	StravaActivityG[] sag = sr.getStravaActivity();
//	
//	assertNotNull("Error when getting the activity's array", sag);
//	
//	// Show result
//			System.out.println("Listing all activities:");
//	for(Integer i =0;i<sag.length;i++) {	
//		
//	System.out.println("StravaActivityG "  +i+ " : " + sag[i].getName() + " (ID=" + sag[i].getId().toString() + ")");
//			}
//}
//}
