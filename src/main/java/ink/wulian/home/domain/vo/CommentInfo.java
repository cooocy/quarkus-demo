package ink.wulian.home.domain.vo;

import ink.wulian.home.domain.entity.Comment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentInfo {

    private Long id;

    private LocalDateTime insertTime;

    private Integer articleId;

    private String nickname;

    private String email;

    private String body;

    public static CommentInfo convert(Comment comment) {
        if (comment == null) {
            return null;
        }
        CommentInfo info = new CommentInfo();
        info.id = comment.getId();
        info.insertTime = comment.getInsertTime();
        info.articleId = comment.getArticleId();
        info.nickname = comment.getNickname();
        info.email = comment.getEmail();
        info.body = comment.getBody();
        return info;
    }

}
