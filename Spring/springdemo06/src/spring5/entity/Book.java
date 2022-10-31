package spring5.entity;

public class Book {
    private int userId;
    private String username;
    private String ustatus;

    public Book() {
    }

    public Book(int userId, String username, String ustatus) {
        this.userId = userId;
        this.username = username;
        this.ustatus = ustatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", ustatus='" + ustatus + '\'' +
                '}';
    }
}
