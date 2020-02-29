package com.mantra.finance.tools;

import lombok.Data;

@Data
public class SimpleResponse<T> {
    private final T status;
    private final String message;

}
