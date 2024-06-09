package rs.ac.uns.ftn.BookingBaboon.dtos.shared;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageCreateRequest {
    @Pattern(regexp = "[a-zA-Z0-9 ./]+")
    @Size(min = 1)
    String path;

    @Pattern(regexp = "[a-zA-Z0-9 ./]+")
    @Size(min = 1)
    String fileName;

    @NotNull
    MultipartFile content;
}
