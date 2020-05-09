package tema3ex3;

public class MediaEntity {
    private Integer noOfDownloads;
    private String type;
    private String title;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNoOfDownloads() {
        Integer integer=noOfDownloads;
        return integer;
    }

    public void setNoOfDownloads(Integer noOfDownloads) {
        this.noOfDownloads = noOfDownloads;
    }
}
