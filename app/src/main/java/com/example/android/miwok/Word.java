package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private static final int no_image_id=-1;
    private int mImageResourceId=no_image_id;
    private int mAudioResouceId;
    public Word(String defaultTranslation, String miwokTranslation,int AudioResouceId)
    {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation =miwokTranslation;
        mAudioResouceId=AudioResouceId;
    }
    public Word(String defaultTranslation, String miwokTranslation,int ImageResourceId,int AudioResourceid)
    {
        mImageResourceId=ImageResourceId;
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation =miwokTranslation;
        mAudioResouceId=AudioResourceid;

    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;}
    public  String getmMiwokTranslation()
    {
        return mMiwokTranslation;
    }
    public int getmImageResourceId(){
        return mImageResourceId;
    }
    public boolean has_image()
    {
        return mImageResourceId!=no_image_id;
    }
    public int getAudioResouceId()
    {
        return mAudioResouceId;
    }
}
