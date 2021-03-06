package com.nubnasir.newsstories.common.controller;

import com.nubnasir.newsstories.authentication.model.session.UserInfo;
import com.nubnasir.newsstories.common.enums.UserTypeEnum;

import javax.servlet.http.HttpSession;

public class BaseController {

    protected String OPERATION_TYPE = "operationType";
    protected String SESSION_USER_INFO_KEY= "userInfo";

    public long getAuthenticatedUserId(HttpSession session){
        UserInfo userInfo = getAuthenticatedUserInfo(session);
        return userInfo != null? userInfo.getId() : UserTypeEnum.ANONYMOUS.getCode();
    }

    public UserInfo getAuthenticatedUserInfo(HttpSession session){
        return (UserInfo) session.getAttribute(SESSION_USER_INFO_KEY);
    }
}
