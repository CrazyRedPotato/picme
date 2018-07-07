package com.picme.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.picme.pojo.Album;
import com.picme.pojo.User;
import com.picme.service.AlbumService;
import com.picme.utils.MyJsonUtil;

@Controller
@RequestMapping("album/")
public class AlbumController {

	@Autowired
	AlbumService albumService;
	
	@RequestMapping(value = "/album/add", method = RequestMethod.GET)
	public @ResponseBody String albumAdd(HttpServletRequest req) {
//		User user = (User) req.getSession().getAttribute("user");
		Album album = JSONObject.parseObject(req.getParameter("album"), Album.class);
//		albumService.userAlbumAdd(user);
		
		MyJsonUtil.addAlbum(album);
		return JSONArray.toJSONString(MyJsonUtil.listAlbum());
	}
	
	@RequestMapping(value = "/album/list", method = RequestMethod.GET)
	public @ResponseBody String albumList(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");
//		albumService.userAlbumList(user);
		MyJsonUtil.listAlbum(user.getId());
		return JSONArray.toJSONString(MyJsonUtil.listAlbum());
	}
	
	@RequestMapping(value = "/album/{album_id}/delete", method = RequestMethod.GET)
	public @ResponseBody String albumDelete(HttpServletRequest req) {
//		User user = (User) req.getSession().getAttribute("user");
		Album album = JSONObject.parseObject(req.getParameter("album"), Album.class);
		
		MyJsonUtil.deleteAlbum(album);
		return JSONArray.toJSONString(MyJsonUtil.listAlbum());
	}
	
	@RequestMapping(value = "/album/{album_id}/update", method = RequestMethod.GET)
	public @ResponseBody String albumUpdate(HttpServletRequest req) {
		Album album = JSONObject.parseObject(req.getParameter("album"), Album.class);
//		albumService.userAlbumUpdate(user);
		MyJsonUtil.updateAlbum(album);
		return JSONArray.toJSONString(MyJsonUtil.listAlbum());
	}
	
	@RequestMapping(value = "/album/{album_id}/upload", method = RequestMethod.POST, produces="text/json;charset=UTF-8")
	public @ResponseBody String albumUpload(HttpServletRequest req, 
			@PathVariable String albumname, @RequestParam("file")MultipartFile file) throws IOException {
		
		if (file.isEmpty()) {
			return "";
		}
		
//		log.debug("Process Upload File:" + file.getOriginalFilename());
		String filepath, filename, filesuffix; 
		filepath = "E:\\javawork_picture\\useralbum";
		filename = System.currentTimeMillis() + file.getOriginalFilename();
		filesuffix = filename.substring(filename.lastIndexOf('.'));
		File filedst = new File(filepath, filename);
		FileUtils.copyInputStreamToFile(file.getInputStream(), filedst);
		return "上传成功";
	}
}
