package guiBrokenLinks;

public class ThreadForMainTask implements Runnable {
	private MainFrameController mainFrame;

	@Override
	public void run() 
	//execute the run method from MainFrameController on a different thread in order to not freeze the GUI
	{

		try {
			mainFrame.run();
		} catch (Exception e) {
			System.out.println("Error ThreadForMainTask");
			e.printStackTrace();
		}

	}

	public void getClass(MainFrameController m) {
		this.mainFrame = m;
	}

}
