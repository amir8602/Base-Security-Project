package com.amir.book;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BookModel {

    private Long id;

    private String name;

    private String authorName;

    private Integer count;


}
