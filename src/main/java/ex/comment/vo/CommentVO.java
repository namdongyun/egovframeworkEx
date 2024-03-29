package ex.comment.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentVO {
	private int id;
	private int boardId;
	private String userName;
	private String content;
	private String date;
}
