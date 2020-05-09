package tema3ex3;

public class Book extends MediaEntity {
    private String author;
    private String publishingHouse;

   public Book(Integer noOfDownloads, String title, String type, String author, String publishingHouse){
       super.setNoOfDownloads(noOfDownloads);
       super.setTitle(title);
       super.setType(type);
        this.author=author;
        this.publishingHouse=publishingHouse;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}
