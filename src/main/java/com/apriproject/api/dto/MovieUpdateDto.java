package com.apriproject.api.dto;

import com.apriproject.api.entity.Category;
import com.apriproject.api.entity.Director;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class MovieUpdateDto {
  private String title;
  private String releaseDate;
  private String rating;
  private String description;
  private Category category;
  private Director director;
}
