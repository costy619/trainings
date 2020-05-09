package tema3ex3;

import java.util.Comparator;

public class NoofDownloadsSort implements Comparator<MediaEntity> {


    @Override
    public int compare(MediaEntity o1, MediaEntity o2) {
        return o2.getNoOfDownloads().compareTo(o1.getNoOfDownloads());
    }
}
