package Ijse.Bo.custom;

import Ijse.Dto.AdminDto;

public interface AdminBo {
    boolean SaveAdmin(AdminDto adminDto);

    boolean checkAdmin(AdminDto adminDto);

    int getGeneratedId();
}