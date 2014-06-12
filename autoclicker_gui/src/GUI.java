import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.DragDetectEvent;


public class GUI {

	protected Shell shlJumperbuddy;
	private Text txtInOrderTo;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text displayText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlJumperbuddy.open();
		shlJumperbuddy.layout();
		while (!shlJumperbuddy.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlJumperbuddy = new Shell();
		shlJumperbuddy.setMinimumSize(new Point(140, 50));
		shlJumperbuddy.setBackground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		shlJumperbuddy.setSize(420, 228);
		shlJumperbuddy.setText("JumperBuddy");
		shlJumperbuddy.setLayout(null);
		
		Slider timeSlider = new Slider(shlJumperbuddy, SWT.NONE);
		timeSlider.addDragDetectListener(new DragDetectListener() {
			public void dragDetected(DragDetectEvent arg0) {
				
			}
		});
		timeSlider.setBounds(10, 70, 384, 17);
		formToolkit.setBorderStyle(SWT.NULL);
		formToolkit.adapt(timeSlider, true, true);
		
		Button startButton = new Button(shlJumperbuddy, SWT.NONE);
		startButton.setBounds(10, 132, 384, 47);
		formToolkit.adapt(startButton, true, true);
		startButton.setText("Start jumping");
		
		displayText = new Text(shlJumperbuddy, SWT.READ_ONLY | SWT.CENTER);
		displayText.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		displayText.setText("Time between jumps:");
		displayText.setBounds(10, 10, 384, 21);
		formToolkit.adapt(displayText, true, true);

	}


}
