package rs.ac.uns.ftn.BookingBaboon.domain.shared;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "images")
@TableGenerator(name="image_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="image", valueColumnName="value_pk")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "image_id_generator")
    Long id;
    String path;
    String fileName;
    @Transient
    byte[] content;

    public Image(String path, String fileName, byte[] contentBytes) {
        this.path = path;
        this.fileName = fileName;
        this.content = contentBytes;
    }

    public Image(){}
}
