package interviewJava8QA;

public class PrintNumFunc implements Runnable {
	
	private Object obj;
	private final int count = 5;

	public PrintNumFunc(Object obj) {
		this.obj = obj;
	}



	@Override
	public void run() {
		
		for(int i = 0; i<count; i++) {
			
			if(i%2==0) {
			synchronized (obj) {
				QuestionsMain.printNextInt(Thread.currentThread().getName(), obj);	
				try {
					if(i<count-1) obj.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} 
			}else if(i%2!=0) {
				synchronized (obj) {
					QuestionsMain.printNextInt(Thread.currentThread().getName(), obj);	
					try {
						if(i<count-1) obj.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

				}
			}
			


		
		}
		
	}

}
