package com.picme.mapper;

import com.picme.pojo.User;

public interface UserMapper {
    public User login(User user);
    public int registered(User user);
    public User getbymail(String mail);
}
