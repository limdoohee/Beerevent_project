package member.action;

/*

 	ActionForwardŬ������ Action�������̽����� ����� �����ϰ� ������� ������ �������� �� ���Ǵ� Ŭ���� �Դϴ�.
 	�� Ŭ������ ��Redirect ���� ���� �������� �������� ��ġ�ڸ� ������ �ֽ��ϴ�.
 	�� ������ FrontController���� ActionForwardŬ���� Ÿ������ ��ȯ���� ��������
 	�� ���� Ȯ���Ͽ� �ش��ϴ� ��û �������� ������ ó���� �մϴ�.
 	
 */
public class ActionForward {
	private boolean redirect=false;
	private String path=null;	
	
	//property Redirect�� is�޼ҵ�
	//������Ƽ Ÿ���� boolean�� ��� get��� is�� �տ� ���� �� �ֽ��ϴ�.
	public boolean isRedirect() {
		return redirect;
	}
	
	public void setRedirect(boolean b ) {
		redirect = b;
	}
	public String getPath( ) {
		return path;
	}
	
	public void setPath(String string) {
		path = string;
	}
}

