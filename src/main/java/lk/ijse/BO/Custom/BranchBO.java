package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.DTO.BranchDto;

import java.sql.SQLException;
import java.util.List;

public interface BranchBO extends SuperBO {
    boolean addBranch(BranchDto Dto) throws SQLException, ClassNotFoundException;

    List<BranchDto> getAllBranchs() throws Exception;

    boolean deleteBranch(String branchId) throws SQLException, ClassNotFoundException;

    boolean UpdateBranch(BranchDto branchDto) throws SQLException, ClassNotFoundException;

    List<String> getBranchIds();
}
