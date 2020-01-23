package tema3ex3;

public class Video extends MediaEntity{
    private String duration;
    Boolean fullHD;

    Video(Integer noOfDownloads, String title, String type, String duration, boolean fullHD){
        super.setNoOfDownloads(noOfDownloads);
        super.setTitle(title);
        super.setType(type);
        this.duration=duration;
        this.fullHD=fullHD;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
