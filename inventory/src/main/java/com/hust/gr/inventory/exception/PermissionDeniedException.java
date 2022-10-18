package com.hust.gr.inventory.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PermissionDeniedException extends RuntimeException {
    public PermissionDeniedException(String message) {
        super(message);
    }
}
