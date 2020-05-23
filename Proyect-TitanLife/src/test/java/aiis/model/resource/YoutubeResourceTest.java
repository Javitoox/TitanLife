package aiis.model.resource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


import aiss.model.youtube.PlayListsResult;
import aiss.model.youtube.VideosPlayListResult;
import aiss.model.youtube.YoutubeVideo;

public class YoutubeResourceTest {
	
	static String access_token="ya29.a0AfH6SMDqYlcCkiU-WN9hWK6I2mIOJnA00iz-pFy0MJaQk-FHM0xA-DvrEmPSUkEffbGPdGAENwNJ5pRNDzbIL9wRPf74Wbr5T8ur2tWzU5O4zzc5RdfR54-4PaQUU3W6tA-1IcnGLqZalfARNpaRfF2szLWFa43SHEzc";
	
	static YoutubeVideo yv1 =new YoutubeVideo();
	static PlayListsResult pl1 =new PlayListsResult();
	static VideosPlayListResult vplr1= new VideosPlayListResult();
	static YoutubeResource yr = new YoutubeResource(access_token);

//	@BeforeClass
//	public static void setup() throws Exception {
//		
//		yr.insertVideoInPlaylist("PLZwDIUWnwYjmyZFdgAllp0n9DI4goJoRo", "2w9CraKrHA0");
//		
//	}
//	
//	@Test
//	public void testdeleteVideoInPlaylist() {
//		
//		
//		boolean res  = yr.deletVideoInPlaylist("2w9CraKrHA0");
//		
//		assertTrue("Error when deleting the video in the playlist", res);
//		
//		System.out.println(res);
//
//		
//	}
//////	
////	@Test
////	public void testgetVideosOfPlayList() {
////		
////		vplr1  = yr.getVideosOfPlayList("PLZwDIUWnwYjmyZFdgAllp0n9DI4goJoRo");
////		
////		assertNotNull("Error when getting the videos from the playlist", vplr1);
////		
////		System.out.println(vplr1.getEtag().toString());
////
////		}
//////	
//////	
////	@Test
////	public void testinsertVideoInPlaylist() {		
////
////		boolean res  = yr.insertVideoInPlaylist("PLZwDIUWnwYjmyZFdgAllp0n9DI4goJoRo", "wF2WNSrNL1E");
////		
////		assertTrue("Error when inserting the video in the playlist", res);
////		
////		System.out.println(res);
////
////		
////	}
////
////	@Test
////	public void testgetYoutubeVideo() {
////		
////		yv1 = yr.getSearchVideos("Ejercicios calistenia");
////		
////		assertNotNull("Error when getting youtube videos by a search", yv1);
////		
////		System.out.println(yv1.getItems().get(0).getId());
////		
////		
////	}
////	@Test
////	public void testgetPlayLists() {
////		
////		pl1 = yr.getPlayLists();
////		
////		assertNotNull("Error when getting the playlists", pl1);
////		
////		System.out.println(pl1.getEtag().toString());
////		
////		
////	}
////	@Test
////	public void testcreatePlayListTitanLife() {
////		
////		boolean res  = yr.createPlayListTitanLife();
////		
////		assertTrue("Error when creating the playlist", res);
////		
////		System.out.println(res);
////		
////		
////	}
}