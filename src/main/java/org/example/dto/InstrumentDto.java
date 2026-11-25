package org.example.dto;

public class InstrumentDto {

    public static class InstrumentCreateRequest{

        private String name;
        private String type;

        public InstrumentCreateRequest(){}

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
