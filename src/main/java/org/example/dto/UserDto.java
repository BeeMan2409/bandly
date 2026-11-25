package org.example.dto;

public class UserDto {

    public static class UserCreateRequest{

        private String name;
        private String tg;

        public UserCreateRequest(){}

        public String getName() {
            return name;
        }

        public String getTg() {
            return tg;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTg(String tg) {
            this.tg = tg;
        }
    }

}
