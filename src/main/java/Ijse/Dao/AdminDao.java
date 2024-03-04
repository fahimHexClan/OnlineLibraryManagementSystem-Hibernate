package Ijse.Dao;

import Ijse.Entity.AdminEntity;

public interface AdminDao {
    boolean saveAdmin(AdminEntity adminEntity);

    boolean checkAdmin(AdminEntity adminEntity);
    int getGeneratedId();

}