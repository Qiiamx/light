package org.light.server.enums;

public enum UserTypeEnum {
    管理员(1),
    审核(2),
    用户(3);

    private Integer type;

    UserTypeEnum(Integer type){
        this.type = type;
    }

    public Integer type() {
        return this.type;
    }

    public static String format(Integer type){
        UserTypeEnum[] values = UserTypeEnum.values();
        for(UserTypeEnum u : values){
            if(u.type().equals(type)){
                return u.name();
            }
        }
        return null;
    }
}
