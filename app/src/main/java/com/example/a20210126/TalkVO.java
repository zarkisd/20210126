package com.example.a20210126;

public class TalkVO {
    //vo 설계 필요할때
    //1. field
    //2. 생성자 메소드
    //3. get/set
    //====================
    //4. toString()

    private int img;
    private String tv_name, tv_text, tv_time;
    public TalkVO(){

    }

    public TalkVO(int img, String tv_name, String tv_text, String tv_time) {
        this.img = img;
        this.tv_name = tv_name;
        this.tv_text = tv_text;
        this.tv_time = tv_time;
    }

    public int getImg() {
        return img;
    }

    public String getTv_name() {
        return tv_name;
    }

    public String getTv_text() {
        return tv_text;
    }

    public String getTv_time() {
        return tv_time;
    }

    @Override
    public String toString() {
        return "TalkVO{" +
                "img=" + img +
                ", tv_name='" + tv_name + '\'' +
                ", tv_text='" + tv_text + '\'' +
                ", tv_time='" + tv_time + '\'' +
                '}';
    }
}
