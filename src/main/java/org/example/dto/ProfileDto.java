package org.example.dto;

public class ProfileDto {

    public static class ProfileCreateRequest{
        private String name;
        private String  description;
        public enum Type { MUSICIAN, BAND }
        private Type profileType;
        private String owner;

        public ProfileCreateRequest(){}

        public String getName() {return name;}
        public String getDescription() {return description;}
        public Type getType() {return profileType;}
        public String getOwner() {return owner;}
        public void setName(String name) {this.name = name;}
        public void setDescription(String description) {this.description = description;}
        public void setType(Type type) {this.profileType = type;}
        public void setOwner(String owner) {this.owner = owner;}
    }

}
