package map.action;

public class ActionForward {
	private boolean redirect=false;
	private String path=null;	
	
	// property Redirect�� is �޼���
		public boolean isRedirect() {
			//������Ƽ Ÿ���� boolean�� ��� get ��� is�� �տ� ���� �� �ֽ��ϴ�.
			return redirect;
		}
		
		//property Redirect�� set�޼ҵ�
		public void setRedirect(boolean b) {
			redirect=b;
		}
		
		//property path�� get�޼ҵ�
		public String getPath() {
			return path;
		}
		
		// property path�� set�޼ҵ�
		public void setPath(String string) {
			path=string;
		}
}
