package org.example.dto;

public class GenreDto {

    public static class GenreCreateRequest{

        private String name;

        public GenreCreateRequest(){}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
