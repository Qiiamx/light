package org.light.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GameDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
