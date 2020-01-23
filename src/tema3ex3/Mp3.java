package tema3ex3;

public class Mp3 extends MediaEntity {
    private String singer;
    private String album;

    Mp3(Integer noOfDownloads, String title, String type, String singer, String album){
        super.setNoOfDownloads(noOfDownloads);
        super.setTitle(title);
        super.setType(type);
        this.album=album;
        this.singer=singer;
    }
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
