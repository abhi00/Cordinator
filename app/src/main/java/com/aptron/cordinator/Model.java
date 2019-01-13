package com.aptron.cordinator;

public class Model {
    public static final int TEXT_TYPE=0;
    public static final int IMAGE_TYPE=1;

    public int type;
    public String text;
    public int image;
    public int sub_image;
    public String subject;

    public Model(int type, String text, int image,int sub_image ,String subject)
    {
        this.type=type;
        this.image = image;
        this.text=text;
        this.sub_image= sub_image;
        this.subject = subject;
    }

    public static int getTextType() {
        return TEXT_TYPE;
    }

    public static int getImageType() {
        return IMAGE_TYPE;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSub_image() {
        return sub_image;
    }

    public void setSub_image(int sub_image) {
        this.sub_image = sub_image;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
