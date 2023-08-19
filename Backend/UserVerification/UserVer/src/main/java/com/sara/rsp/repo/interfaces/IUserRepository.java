package com.sara.rsp.repo.interfaces;

import com.sara.rsp.entity.*;

import java.util.List;

public interface IUserRepository {
    int insertNewApplication(UserApplication user, DrivingLicense license);
    List<UserApplication> getPendingApplications();
    UserApplication getPendingApplicationByUserId(int userId);
    int rejectApplication(UserApplication application);
    int approveApplication(UserApplication application, AuthUser user);
    DrivingLicense getDrivingLicense(int id);
    //int insertAuthUser(AuthUser authUser);
    AuthUser findUserByEmail(String email);
    AuthUser findByEmail(String email);
}
