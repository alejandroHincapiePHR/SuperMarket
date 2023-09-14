package com.SuperMarket.SuperMarket.domain.base;

public enum StateEnum {

    ACTIVE(1, "Active"),
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
        for (StateEnum stateEnum : StateEnum.values()) {
            if (stateEnum.getValue().equals(value)) {
                return stateEnum;
            }
        }
        throw new IllegalArgumentException("Value " + value + " not found");
    }

    public static StateEnum fromState(String description) {
        for (StateEnum stateEnum : StateEnum.values()) {
            if (stateEnum.getDescription().equals(description)) {
                return stateEnum;
            }
        }
        throw new IllegalArgumentException("Value " + description + " not found");
    }
}
