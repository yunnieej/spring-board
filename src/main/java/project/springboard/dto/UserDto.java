package project.springboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.springboard.entity.User;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

//    private Long id;
    @Size(min=6, max=20, message="아이디는 6자 이상 20자 이하로 입력해주세요.")
    private String userId;
    @Size(min=8, max=20, message="비밀번호는 문자, 숫자, 특수문자 포함 8자 이상 20자 이하로 입력해주세요.")
    private String userPassword;
    private String userName;

    @Builder
    public UserDto(Long id, String userId, String userPassword, String userName){
//        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public User toEntity(){
        return User.builder()
//                .id(id)
                .userId(userId)
                .userPassword(userPassword)
                .userName(userName)
                .build();
    }
}
