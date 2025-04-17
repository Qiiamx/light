package org.light.server.enums;

public enum ThirdTypeEnum {
    支付宝("zfb"),
    微信("wx");

    private String type;

    ThirdTypeEnum(String type){
        this.type = type;
    }

    public String type() {
        return this.type;
    }

    public static String format(String type){
        ThirdTypeEnum[] values = ThirdTypeEnum.values();
        for(ThirdTypeEnum u : values){
            if(u.type().equals(type)){
                return u.name();
            }
        }
        return null;
    }
}
