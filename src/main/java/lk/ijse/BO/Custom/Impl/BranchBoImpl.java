package lk.ijse.BO.Custom.Impl;

import lk.ijse.BO.Custom.BranchBO;
import lk.ijse.DAO.Custom.BranchDao;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DTO.BranchDto;
import lk.ijse.Entity.Branch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchBoImpl implements BranchBO {
    BranchDao branchDao = (BranchDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BRANCH);

    @Override
    public boolean addBranch(BranchDto dto) throws SQLException, ClassNotFoundException {
        return branchDao.save(new Branch(dto.getBranchId(), dto.getBranchName(), dto.getBranchLocation()));


    }

    @Override
    public List<BranchDto> getAllBranchs() throws Exception {
        List<BranchDto> allBranchs= new ArrayList<>();
        List<Branch> all = branchDao.getAll();
        for (Branch c : all) {
            allBranchs.add(new BranchDto(c.getBranchId(), c.getBranchName(), c.getBranchLocation()));        }
        return allBranchs;
    }

    @Override
    public boolean deleteBranch(String branchId) throws SQLException, ClassNotFoundException {
        return branchDao.delete(branchId);
    }

    @Override
    public boolean UpdateBranch(BranchDto dto) throws SQLException, ClassNotFoundException {
        return branchDao.update(new Branch(dto.getBranchId(), dto.getBranchName(), dto.getBranchLocation()));
    }

    @Override
    public List<String> getBranchIds() {
        return branchDao.getIds();
    }
}
