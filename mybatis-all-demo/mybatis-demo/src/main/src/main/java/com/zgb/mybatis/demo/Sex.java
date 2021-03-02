package com.zgb.mybatis.demo;

public enum Sex {

    MALE(1, "男"), FEMALE(2, "女");

    private Integer code;
    private String value;

    private Sex(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据code获得value
     * 
     * @param code
     * @return
     */
    public static String getValue(Integer code) {
        String value = null;
        for (Sex sex : Sex.values()) {
            if (sex.getCode().equals(code)) {
                value = sex.getValue();
            }
        }
        return value;
    }

    /**
     * 根据code获取sex
     * 
     * @param code
     * @return
     */
    public static Sex getSex(Integer code) {
        for (Sex sex : Sex.values()) {
            if (sex.getCode().equals(code)) {
                return sex;
            }
        }
        return null;
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}