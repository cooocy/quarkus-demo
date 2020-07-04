package ink.wulian.home.repository;

import ink.wulian.home.domain.entity.Comment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CommentRepository implements PanacheRepository<Comment> {

    public List<Comment> listByArticleId(long articleId) {
        return find("delete_flag = ?1 and article_id = ?2", Sort.by("id").ascending(), 0, articleId).list();
    }

}
