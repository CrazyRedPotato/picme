package com.picme.utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.picme.pojo.Album;

public class MyJsonUtil {
	public static final String filepath = "E:\\javawork_picture\\json\\";
	public static final String filename = "album.json";
	
	public static List<Album> listAlbum() {
		String jsonArrayString = MyFileUtils.readToString(filepath+filename);
		
	    List<com.picme.pojo.Album> albumlist = JSONArray.parseArray(jsonArrayString, com.picme.pojo.Album.class);
		
	    if (albumlist == null) {
	    	albumlist = new ArrayList<Album>();
	    }
		return albumlist;
		
	}
	
	public static List<Album> listAlbum(int user_id) {
		String jsonArrayString = MyFileUtils.readToString(filepath+filename);
		
	    List<com.picme.pojo.Album> albumlist = JSONArray.parseArray(jsonArrayString, com.picme.pojo.Album.class);
		
	    if (albumlist == null) {
	    	albumlist = new ArrayList<Album>();
	    	return albumlist;	    
	    }
	    List<Album> userAlbum = new ArrayList<>();
		
	    for (Album a : albumlist) {
	    	if (a.getUser_id() == user_id) {
	    		userAlbum.add(a);  
	    	}
	    }
	    
	    return userAlbum;
	}
	
	public static void updateAlbum(Album album) {
	    List<com.picme.pojo.Album> albumlist = listAlbum();
	    
	    for (Album a : albumlist) {
	    	if ((a.getId() == album.getId()) && (a.getUser_id() == album.getUser_id())) {
	    		a.setComments(album.getComments());
	    		a.setCover_url(album.getCover_url());
	    		a.setCreatetime(album.getCreatetime());
	    		a.setName(album.getName());
	    		a.setRight(album.getRight());
	    		a.setUser_id(album.getUser_id());
	    	}
	    }
		
	    writeAlbum(albumlist);
		return;
	}
	
	public static void deleteAlbum(Album album) {
	    List<com.picme.pojo.Album> albumlist = listAlbum();
	    
	    for (Album a : albumlist) {
	    	if ((a.getId() == album.getId()) && (a.getUser_id() == album.getUser_id())) {
	    		/* 循环中删除元素只能删除一个后break，删除后继续循环会报ConcurrentModificationException异常 */
	    		/* 使用iterator循环遍历时，使用iterator的remove方法可以在循环中连续删除元素，但使用list的remove也会报异常 */
	    		albumlist.remove(a);
	    		break;
	    	}
	    }
		
	    writeAlbum(albumlist);
		return;
	}
	
	public static void addAlbum(Album album) {
	    List<com.picme.pojo.Album> albumlist = listAlbum();
	    int max_id = 0;
	    for (Album a : albumlist) {
	    	if (a.getUser_id() > max_id) {
	    		max_id = a.getUser_id();
	    	}
	    }
		
	    if (max_id == 0) {
	    	max_id = 1;
	    }
	    album.setId(max_id);
	    albumlist.add(album);
	    writeAlbum(albumlist);
		return;
	}
	
	public static void writeAlbum(List<Album> albumlist) {
		String jsonArrayString = JSONArray.toJSONString(albumlist);
		
		MyFileUtils.writeToFile(filepath+filename, jsonArrayString);
		
		return;
	}
	
	
	
	
	@Test
	public void testjson() {
		List<Album> list = new ArrayList<Album>();
		Album album =  new Album();
		album.setCreatetime(new Timestamp(System.currentTimeMillis()));
		album.setId(1);
		album.setName("测试相册");
		album.setUser_id(1);
		list.add(album);
		
	    System.out.println("albumlist: " + list);
	    
	    writeAlbum(list);
	    
	    list = listAlbum();
	    
	    System.out.println("after write albumlist: " + list);
	}
	
	@Test
	public void testlist() {
		List<Album> list = new ArrayList<Album>();
		Album album =  new Album();
		album.setCreatetime(new Timestamp(System.currentTimeMillis()));
		album.setId(1);
		album.setName("测试相册");
		album.setUser_id(1);
		list.add(album);
		
	    System.out.println("albumlist: " + list);
	    
	    writeAlbum(list);
		
		List<Album> userAlbum = listAlbum(1);
	    System.out.println(userAlbum);
	    System.out.println(JSONArray.toJSON(userAlbum));
	    userAlbum = listAlbum(2);
		
	    System.out.println(userAlbum);
	    System.out.println(JSONArray.toJSON(userAlbum));
	}
	
}
