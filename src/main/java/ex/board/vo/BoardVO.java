package ex.board.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author HP 15
 *
 */
@Getter
@Setter
public class BoardVO {
	@Override
	public String toString() {
		
		return "BoardVO{" +
	            "title='" + title + '\'' +
	            ", content='" + content + '\'' +
	            ", writer='" + name + '\'' +
	            ", date='" + date + '\'' + 
	            '}';
	}
	private int id;
	private String title;
	private String content;
	private String name;
	private String date;
}
