package org.light.server.enums;

public enum ReportStatusEnum {
    已举报(5),
    处理中(25),
    已处理(50),
    取消(90);

    private Integer type;

    ReportStatusEnum(Integer type){
        this.type = type;
    }

    public Integer type() {
        return this.type;
    }

    public static String format(Integer type){
        ReportStatusEnum[] values = ReportStatusEnum.values();
        for(ReportStatusEnum u : values){
            if(u.type().equals(type)){
                return u.name();
            }
        }
        return null;
    }
}
