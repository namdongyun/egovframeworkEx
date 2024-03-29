package ex.cmmn.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {
	private int pageNum = 1;	// 현재 페이지 번호
    private int pageSize = 10;	// 페이지당 개수
    private int offset;	// 페이징 처리를 위한 offset 값
    private int totalElements;  // 전체 데이터 수
    private int totalPages;     // 총 페이지 수
    
    
    // 페이징 처리를 위해 offset 값을 계산하고 설정하는 메서드
    public void calculateOffset() {
        this.offset = (this.pageNum - 1) * this.pageSize;
       
    }
    
    // 전체 데이터 수를 기반으로 총 페이지 수를 계산하고 설정하는 메서드
    public void calculateTotalPages() {
        this.totalPages = (int) Math.ceil((double) this.totalElements / this.pageSize);
    }
}
