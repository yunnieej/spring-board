package project.springboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.springboard.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

//    private Long id;
    @NotBlank(message="아이디는 필수 입력 항목입니다.")
    @Size(min=6, max=20, message="아이디는 6자 이상 20자 이하로 입력해주세요.")
    private String userId;

    @NotBlank(message="비밀번호는 필수 입력 항목입니다.")
    @Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$",message="비밀번호는 문자, 숫자, 특수문자 포함하여 8자 이상 20자 이하로 입력해주세요.")
    private String userPassword;

    @NotBlank(message = "이름은 필수 입력 항목입니다.")
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
