package org.sopt.spring.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record BlogCreateRequest(
        String title,
        String description

) {
}
