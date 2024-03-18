package lk.ijse.DTO;

public class BranchDto {
    String BranchId;
    String BranchName;
    String BranchLocation;

    public BranchDto() {
    }

    public BranchDto(String branchId, String branchName, String branchLocation) {
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

