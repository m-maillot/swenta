package fr.mmaillot.swenta.model;

import java.io.Serializable;

/**
 * News UI model
 */
public class NewsModel implements Serializable {

    private final String mTitle;

    private final String mPicture;

    private final String mSummary;

    private final String mContent;

    public NewsModel(String pTitle, String pPicture, String pSummary, String pContent) {
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
