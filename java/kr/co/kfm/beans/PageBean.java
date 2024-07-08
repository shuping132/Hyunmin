package kr.co.kfm.beans;

public class PageBean {
	// �ּ� ������ ��ȣ
	private int min;
// �ִ� ������ ��ȣ
	private int max;
// ���� ��ư�� ������ ��ȣ
	private int prevPage;
// ���� ��ư�� ������ ��ȣ
	private int nextPage;
// ��ü ������ ����
	private int pageCnt;
// ���� ������ ��ȣ
	private int currentPage;
	
	//contentCnt: ��ü�� ����, currentPage:���� �� ��ȣ, contentPageCnt: �������� ���� ���� paginationCnt: ������ ��ư�� ����
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		//���� ������ ��ȣ
		this.currentPage = currentPage;
		
		//��ü ������ ����
		pageCnt = contentCnt / contentPageCnt;
		
		//553/10=53 ... 3 53+1=54
		if(contentCnt % contentPageCnt >0) {
			pageCnt++;
		}//id
		
		/*
		 1 ~ 10(�� �ּҹ�ȣ1 ���� �ִ��ȣ 10) : 1
		 11 ~ 20 : �ּҽ��۹�ȣ 11
		 21 ~ 30 : �ּҽ��۹�ȣ 21
		 
		 //-1
		 0~9 :1
		 10~19 :10
		 20~29 :20
		 
		 //�������� ���� ������ ����
		 0:1
		 1:11
		 2:21
		 //�������� ���� ������ �ٽ� ����
		 0:1
		 10:11
		 20:21
		 
		 //+1
		 1:1
		 11:11
		 21:21
		 
		 */
		
		min=((currentPage-1)/contentPageCnt)*contentPageCnt+1;
		max=min+paginationCnt -1;//1+10=11 -1
		//64�� => 6������
		if(max > pageCnt) {
			max=pageCnt;
		}
		
		prevPage = min-1;
		nextPage = max +1;
		
		//�������������� �Ѿ�� �ʵ���
		if(nextPage > pageCnt) {
			nextPage=pageCnt;
		}
		
	}//PageBean
	
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	
}
