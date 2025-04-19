package org.light.server.enums;

public enum ValidTypeEnum {
    有效(1),
    无效(2);

    private Integer type;

    ValidTypeEnum(Integer type){
        this.type = type;
    }

    public Integer type() {
        return this.type;
    }

    public static String format(Integer type){
        ValidTypeEnum[] values = ValidTypeEnum.values();
        for(ValidTypeEnum u : values){
            if(u.type().equals(type)){
                return u.name();
            }
        }
        return null;
    }
}
