package org.light.server.enums;

public enum UserEnableEnum {
    启用(1),
    禁用(2);

    private Integer type;

    UserEnableEnum(Integer type){
        this.type = type;
    }

    public Integer type() {
        return this.type;
    }

    public static String format(Integer type){
        UserEnableEnum[] values = UserEnableEnum.values();
        for(UserEnableEnum u : values){
            if(u.type().equals(type)){
                return u.name();
            }
        }
        return null;
    }
}
