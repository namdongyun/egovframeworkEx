package ex.board.vo;

import ex.cmmn.vo.PageVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author HP 15
 *
 */
@Getter
@Setter
@ToString
public class BoardVO extends PageVO{
	private int id;
	private String title;
	private String content;
	private String name;
	private String date;
}
