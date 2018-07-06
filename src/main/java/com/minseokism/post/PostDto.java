package com.minseokism.post;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PostDto {

    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private String code;
}
