package ink.wulian.home.service;

import ink.wulian.home.domain.vo.CommentInfo;
import ink.wulian.home.repository.CommentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CommentService {

    @Inject
    private CommentRepository commentRepository;

    public List<CommentInfo> selectByArticleId(long articleId) {
        return commentRepository.listByArticleId(articleId).stream().map(CommentInfo::convert).collect(Collectors.toList());
    }

}
