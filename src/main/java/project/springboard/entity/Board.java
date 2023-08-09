package project.springboard.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name="board")
@NoArgsConstructor
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Builder
    public Board(Long id, String title, String content, User user){
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }


}
