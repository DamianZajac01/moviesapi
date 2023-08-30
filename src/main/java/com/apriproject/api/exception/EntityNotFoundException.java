package com.apriproject.api.exception;

import java.io.Serial;

public class EntityNotFoundException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 8558152046450792541L;

  public EntityNotFoundException(String message) {
    super(message);
  }

}
