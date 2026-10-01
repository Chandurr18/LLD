package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie {
    private final String id;
    private final String title;
    private final int durationMin;
}
