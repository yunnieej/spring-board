package project.springboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import project.springboard.entity.User;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String loginId;
    private String loginPassword;
    private String name;

    @Builder
    public UserDto(Long id, String loginId, String loginPassword, String name){
        this.id = id;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.name = name;
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .loginId(loginId)
                .loginPassword(loginPassword)
                .name(name)
                .build();
    }
}
