package com.SuperMarket.SuperMarket.domain.base;

public enum StateEnum {

    ACTIVE(1, "ACTIVE"),
    DELETED(2, "DELETED");

    private Integer value;
    private String description;

    private StateEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static StateEnum fromValue(Integer value) {

        if(value==null){
            throw new IllegalArgumentException("A value is needed");
        }

        for (StateEnum stateEnum : StateEnum.values()) {
            if (stateEnum.getValue().equals(value)) {
                return stateEnum;
            }
        }
        throw new IllegalArgumentException("Value " + value + " not found");
    }

    public static StateEnum fromState(String description) {

        if(description==null){
            throw new IllegalArgumentException("A description is needed");
        }


        for (StateEnum stateEnum : StateEnum.values()) {
            if (stateEnum.getDescription().equals(description.toUpperCase())) {
                return stateEnum;
            }
        }
        throw new IllegalArgumentException("Value " + description + " not found");
    }
}
