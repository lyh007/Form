package com.form.model;

import java.io.Serializable;

public enum CompleteRequestStatus implements Serializable {
    //1 (pending), 2 (accept), 3 (rejected)
    PENDING(1),
    ACCEPT(2),
    REJECTED(3);
    private int value;

    CompleteRequestStatus(int value) {
        this.value = value;
    }
    public static CompleteRequestStatus getValueOf(int completeRequestStatus) {
        for (CompleteRequestStatus completeRequestStatusEnum : values()) {
            if (completeRequestStatusEnum.ordinal() == completeRequestStatus) {
                return completeRequestStatusEnum;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println(CompleteRequestStatus.ACCEPT.value);
        System.out.println(CompleteRequestStatus.ACCEPT.ordinal());
    }
}
