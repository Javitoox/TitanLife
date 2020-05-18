package aiis.model.resource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


import aiss.model.youtube.PlayListsResult;
import aiss.model.youtube.VideosPlayListResult;
import aiss.model.youtube.YoutubeVideo;

public class YoutubeResourceTest {
	
	static String access_token="ya29.a0AfH6SMCy9IXfEyz3lEMGU2XWGF1CEK8OhMqIZCcLz51WiTTG_cFWld2UYLO4n2CC2UJuqurVmKWdYMuJwuHgPs0ESm-fO53QSjRSd5rT6w18xlixDQERDQ86uz5stPTp4w0WXlBqrftOu8CZ9qr9_l2Rh-6wc1bzlOE";
	
	static YoutubeVideo yv1 =new YoutubeVideo();
	static PlayListsResult pl1 =new PlayListsResult();
	static VideosPlayListResult vplr1= new VideosPlayListResult();
	static YoutubeResource yr = new YoutubeResource(access_token);

	@BeforeClass
	public static void setup() throws Exception {
		
		// Test song 1
	
		 yr.insertVideoInPlaylist("PLZwDIUWnwYjmyZFdgAllp0n9DI4goJoRo", "2w9CraKrHA0");
		
		// Test song 2
//		sa2 = StravaResource.postStravaRoute("Test", "Run", StravaResource.fromISO8601UTC(), Integer.valueOf("3600"), "Test", Float.valueOf("22222"));
	
	}
	
	@Test
	public void testdeleteVideoInPlaylist() {
		
		boolean res  = yr.deletVideoInPlaylist("2w9CraKrHA0");
		
		assertTrue("Error when deleting the video in the playlist", res);
		
		System.out.println(res);

		
	}
////	
//	@Test
	public void testgetVideosOfPlayList() {
		
		vplr1  = yr.getVideosOfPlayList("PLZwDIUWnwYjmyZFdgAllp0n9DI4goJoRo");
		
		assertNotNull("Error when getting the videos from the playlist", vplr1);
		
		System.out.println(vplr1.getEtag().toString());

		}
////	
//	
	@Test
	public void testinsertVideoInPlaylist() {		

		boolean res  = yr.insertVideoInPlaylist("PLZwDIUWnwYjmyZFdgAllp0n9DI4goJoRo", "wF2WNSrNL1E");
		
		assertTrue("Error when inserting the video in the playlist", res);
		
		System.out.println(res);

		
	}

	@Test
	public void testgetYoutubeVideo() {
		
		yv1 = yr.getSearchVideos("Ejercicios calistenia");
		
		assertNotNull("Error when getting youtube videos by a search", yv1);
		
		System.out.println(yv1.getItems().get(0).getId());
		
		
	}
	@Test
	public void testgetPlayLists() {
		
		pl1 = yr.getPlayLists();
		
		assertNotNull("Error when getting the playlists", pl1);
		
		System.out.println(pl1.getEtag().toString());
		
		
	}
	@Test
	public void testcreatePlayListTitanLife() {
		
		boolean res  = yr.createPlayListTitanLife();
		
		assertTrue("Error when creating the playlist", res);
		
		System.out.println(res);
		
		
	}
}