package project.springboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import project.springboard.entity.Board;
import project.springboard.entity.User;

@Getter
@Setter
public class BoardDto {
    private String title;
    private String content;
    private User user;

    @Builder
    public BoardDto(String title, String content, User user){
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }


}
