package com.enums;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote β Code is like humor. When you have to explain it, itβs bad.β β Cory House
 * @written_on 6/18/21 Friday
 */
public enum Gender {
    MALE, FEMALE, OTHERS;

    public static Gender findByOrdinal(int ordinal) {
        Gender[] genders = Gender.values();
        for (Gender g : genders) {
            if (ordinal == g.ordinal()) {
                return g;
            }
        }
        return null;
    }
}
