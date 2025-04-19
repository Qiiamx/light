package org.light.server.enums;

public enum VerifyStatusEnum {
    作弊(5),
    未作弊(25),
    无法核实(50),
    取消(90);

    private Integer type;

    VerifyStatusEnum(Integer type){
        this.type = type;
    }

    public Integer type() {
        return this.type;
    }

    public static String format(Integer type){
        VerifyStatusEnum[] values = VerifyStatusEnum.values();
        for(VerifyStatusEnum u : values){
            if(u.type().equals(type)){
                return u.name();
            }
        }
        return null;
    }
}
