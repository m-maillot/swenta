package fr.mmaillot.core.repository.entity;

/**
 * Class represent a news extract from source (remote or local)
 */
public class NewsEntity {

    private final String mTitle;

    private final String mPicture;

    private final String mSummary;

    private final String mContent;

    public NewsEntity(String pTitle, String pPicture, String pSummary, String pContent) {
        mTitle = pTitle;
        mPicture = pPicture;
        mSummary = pSummary;
        mContent = pContent;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPicture() {
        return mPicture;
    }

    public String getSummary() {
        return mSummary;
    }

    public String getContent() {
        return mContent;
    }
}
