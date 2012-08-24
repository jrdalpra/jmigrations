package br.com.wolkenapps.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AssertThat {

    public static <T> void isNull(T something) {
        isNull(something, "The object must be null!");
    }

    public static <T> void isNull(T something, String message) {
        if (ConfirmsThat.notIsNull(something)) {
            throw new RuntimeException(message);
        }
    }

    public static <T> void notIsNull(T something) {
        notIsNull(something, "The object must be null!");
    }

    public static <T> void notIsNull(T something, String message) {
        if (ConfirmsThat.isNull(something)) {
            throw new RuntimeException(message);
        }
    }

}
