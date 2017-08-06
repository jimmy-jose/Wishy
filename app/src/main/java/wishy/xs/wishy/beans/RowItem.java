package wishy.xs.wishy.beans;

/**
 * Created by Jimmy on 8/1/2017.
 */

public class RowItem {
    private int imageId;
    private String title;

    public RowItem(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
