package br.com.wolkenapps.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfirmsThat {

    public static Boolean not(Boolean check) {
        return !check;
    }

    public static <T> Boolean isNull(T something) {
        return something == null;
    }

    public static <T> Boolean notIsNull(T something) {
        return not(isNull(something));
    }

    public static <T> Boolean isInstanceOf(T something, Class<?> type) {
        return isNull(something) ? false : type.isInstance(something);
    }

}
