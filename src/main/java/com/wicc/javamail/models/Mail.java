package com.wicc.javamail.models;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author bkings
 * @version 1.0.0
 * @since 2021-12-31 00:06
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mail {
    private String to;
    private String subject;
    private String text;
    private List<MultipartFile> attachments;
}
