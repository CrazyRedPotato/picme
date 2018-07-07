package com.picme.service;

import com.picme.pojo.User;

public interface AlbumService {
	String userAlbumAdd(User user);
	String userAlbumDelete(User user);
	String userAlbumUpdate(User user);
	String userAlbumList(User user);
}
