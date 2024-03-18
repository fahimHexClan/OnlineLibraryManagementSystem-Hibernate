package lk.ijse.DTO;

public class BookDto {
    String ID;
    String Authour;
    String Genre;
    String Title;
    int Status;
    String User;

    public BookDto() {
    }

    public BookDto(String ID, String authour, String genre, String title, int status, String user) {
        this.ID = ID;
        Authour = authour;
        Genre = genre;
        Title = title;
        Status = status;
        User = user;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAuthour() {
        return Authour;
    }

    public void setAuthour(String authour) {
        Authour = authour;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "ID='" + ID + '\'' +
                ", Authour='" + Authour + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Title='" + Title + '\'' +
                ", Status=" + Status +
                ", User='" + User + '\'' +
                '}';
    }
}

