package br.com.app.domain.enums;

import java.util.Arrays;

public enum IfOperStatus {

	UP(1),
    DOWN(2),
    TESTING(3),
    UNKNOWN(4),
    DORMANT(5),
    NOT_PRESENT(6),
    LOWER_LAYER_DOWN(7);

    private final int value;

    IfOperStatus(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }

    public static IfOperStatus byValue(int value) {
        return Arrays.stream(IfOperStatus.values()).filter(st -> st.getValue() == value).findFirst()
                .orElse(UNKNOWN);
    }
}