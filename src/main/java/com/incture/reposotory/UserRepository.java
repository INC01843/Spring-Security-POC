package com.incture.reposotory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class UserRepository {

  public static final UserRole ROLE_USER_ADMIN = new UserRole("ROLE_USER_ADMIN");
  public static final UserRole ROLE_USER = new UserRole("ROLE_USER");

  public static final List<UserRole> ALL_ROLES;

  static {
      List<UserRole> allRoles = Arrays
              .asList(ROLE_USER_ADMIN,ROLE_USER);
      ALL_ROLES = Collections.unmodifiableList(allRoles);

  }

      public static class UserRole {

      private String roleName;

      UserRole(String userRole) {
          this.roleName = userRole;

      }
      public String getRoleName() {
          return roleName;
        }

      }

}
