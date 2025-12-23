class Booktwo {

    // public isbn
    public String ISBN;

    // protected title
    protected String title;

    // private author
    private String author;

    // setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // getter for author
    public String getAuthor() {
        return author;
    }
}

class EBook extends Booktwo {

    // accessing public and protected data
    void display() {
        System.out.println(ISBN + " " + title);
    }
}