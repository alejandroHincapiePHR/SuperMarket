package com.SuperMarket.SuperMarket.domain.base;

import java.util.Objects;

public abstract class Domain {

    protected Long id;
    protected StateEnum stateEnum;

    public Domain() {
        super();
        this.stateEnum = StateEnum.ACTIVE;
    }

    public Domain(Long id) {
        super();
        this.id = id;
        this.stateEnum = StateEnum.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(StateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Domain{");
        sb.append("id=").append(id);
        sb.append(", stateEnum=").append(stateEnum);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null) return false;
        if (!(o instanceof Domain domain)) return false;
        return Objects.equals(id, domain.id) && stateEnum == domain.stateEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stateEnum);
    }
}
