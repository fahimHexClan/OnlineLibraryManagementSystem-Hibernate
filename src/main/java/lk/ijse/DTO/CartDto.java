package lk.ijse.DTO;

public class CartDto extends BorrowDto {
    String ID;
    String Authour;
    String Genre;
    String Title;

    int Count;
    String Date;

    public CartDto(String ID, String authour, String genre, String title, int count, String date) {
        this.ID = ID;
        Authour = authour;
        Genre = genre;
        Title = title;
        Count = count;
        Date = date;
    }

    public CartDto() {

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

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "ID='" + ID + '\'' +
                ", Authour='" + Authour + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Title='" + Title + '\'' +
                ", Count=" + Count +
                ", Date='" + Date + '\'' +
                '}';
    }
}
