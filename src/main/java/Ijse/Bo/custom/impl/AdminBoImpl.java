package Ijse.Bo.custom.impl;

import Ijse.Bo.custom.AdminBo;
import Ijse.Dao.AdminDao;
import Ijse.Dao.Impl.AdminDaoImpl;
import Ijse.Dto.AdminDto;
import Ijse.Entity.AdminEntity;

public class AdminBoImpl implements AdminBo {
    //dao eke object ekak creata karala uda thiyagannawa lees boilerplete code tika adu karnawa
    private  AdminDao adminDao= (AdminDao) new AdminDaoImpl();

    @Override
    public boolean SaveAdmin(AdminDto adminDto) {
        //entity object ekak create karala a dto ekata dagaththa data tika entity ekta dagannawa
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setId(adminDto.getId());
        adminEntity.setPassword(adminDto.getPassword());

        // entity ekata harawala  eyawa dao layer ekata send karanawa
        return adminDao.saveAdmin(adminEntity);
    }
    public boolean checkAdmin(AdminDto adminDto) {
        //mekath entity ekata maru karala  return karanawa Dao ekata
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setId(adminDto.getId());
        adminEntity.setPassword(adminDto.getPassword());
        return adminDao.checkAdmin(adminEntity);
    }
    public int getGeneratedId() {
        //database eke thiyana id eka genarate karala ganna  metanin method eka call karanawa
            return adminDao.getGeneratedId();
    }
}


