package com.form.model;

/**
 * the status for form template will be: 1(Initiative), 2 (In
 * Estimation), 3 (In Development), 4 (In Review), 5 (Active), 6
 * (Inactive).
 */
public enum TemplateStatus {
    INITIATIVE(1),
    INESTIMATION(2),
    INDEVELOPMENT(3),
    INREVIEW(4),
    ACTIVE(5),
    INACTIVE(6);
    private int value;

    TemplateStatus(int value) {
        this.value = value;
    }

    public static TemplateStatus getValueOf(int templateStatus) {
        for (TemplateStatus templateStatusEnum : values()) {
            if (templateStatusEnum.ordinal() == templateStatus) {
                return templateStatusEnum;
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
        System.out.println(TemplateStatus.INITIATIVE.value);
        System.out.println(TemplateStatus.INITIATIVE.ordinal());
        System.out.println(TemplateStatus.INDEVELOPMENT.value);
        System.out.println(TemplateStatus.INDEVELOPMENT.ordinal());
    }
}
