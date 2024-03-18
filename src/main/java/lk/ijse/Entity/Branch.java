package lk.ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Branch {
    @Id
   String BranchId;
   String BranchName;
   String BranchLocation;

    public Branch() {
    }

    public Branch(String branchId, String branchName, String branchLocation) {
        BranchId = branchId;
        BranchName = branchName;
        BranchLocation = branchLocation;
    }

    public String getBranchId() {
        return BranchId;
    }

    public void setBranchId(String branchId) {
        BranchId = branchId;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getBranchLocation() {
        return BranchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        BranchLocation = branchLocation;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "BranchId='" + BranchId + '\'' +
                ", BranchName='" + BranchName + '\'' +
                ", BranchLocation='" + BranchLocation + '\'' +
                '}';
    }
}
