package com.sara.rsp.repo;

import com.sara.rsp.repo.interfaces.*;
import com.sara.rsp.entity.*;
import com.sara.rsp.entity.DTOs.*;

import org.springframework.data.jpa.repository.JpaRepository;

//public interface UserRepository extends JpaRepository<UserApplication, Integer>{

//}

import org.springframework.stereotype.Repository;
//import RideSharingPlatform.Authentication.Models.AuthUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository implements IUserRepository {
    @PersistenceContext
    private EntityManager entityManager;
    
    public int insertNewApplication(UserApplication user, DrivingLicense license) {
        user.setRole(entityManager.find(Role.class, user.getRoleId()));
        entityManager.persist(user);

        if (user.getRoleId() == 1) {
            entityManager.persist(license);
        }
        entityManager.flush();

        return user.getUserId();
    }

    public List<UserApplication> getPendingApplications() {
        return entityManager.createQuery(
                "SELECT u FROM UserApplication u WHERE u.applicationStatus = 'New'", UserApplication.class)
                .getResultList();
    }

    public UserApplication getPendingApplicationByUserId(int userId) {
        return entityManager.createQuery(
                "SELECT u FROM UserApplication u WHERE u.applicationStatus = 'New' AND u.userId = :userId", UserApplication.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    public int rejectApplication(UserApplication application) {
        entityManager.merge(application);
        return application.getUserId();
    }

    public int approveApplication(UserApplication application, AuthUser user) {
        entityManager.merge(application);
        entityManager.persist(user);
        return application.getUserId();
    }

    public DrivingLicense getDrivingLicense(int userId) {
        return entityManager.find(DrivingLicense.class, userId);
    }
    
    /*public int insertAuthUser(AuthUser authUser) {
        entityManager.persist(authUser);
        entityManager.flush();
        return authUser.getAuthUserId();
    }*/
    
    public AuthUser findByEmail(String email) {
        return entityManager.createQuery(
                "SELECT u FROM AuthUser u WHERE u.email = :email", AuthUser.class)
                .setParameter("email", email)
                .getSingleResult();
    }
    
    public AuthUser findUserByEmail(String email) {
        return entityManager.createQuery(
                "SELECT u FROM AuthUser u WHERE u.email = :email", AuthUser.class)
                .setParameter("email", email)
                .getSingleResult();
    }
    
}

