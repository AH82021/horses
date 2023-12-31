package com.binaryCars.horses.exception;

import java.time.LocalDateTime;

public record ApiError(
        String path,
        String message,
        int errorCode,
        LocalDateTime timestamp
) {
}
