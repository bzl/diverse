package c4buddy;

import java.awt.Toolkit;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListenerExample implements NativeKeyListener {
        public void nativeKeyPressed(NativeKeyEvent e) {
                //System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

                if (e.getKeyCode() == NativeKeyEvent.VK_F11) {
                        GlobalScreen.unregisterNativeHook();
                }
                
                if (e.getKeyCode() == NativeKeyEvent.VK_F12){
                	
                	new Thread(new Runnable() {
					    @Override public void run() {
					    	try {
								Thread.sleep(34000);
								//System.out.println("beep");
								Toolkit.getDefaultToolkit().beep();
								
								Thread.sleep(5000);
								
								Toolkit.getDefaultToolkit().beep();
								
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    	
					    }
					}).start();
                	
                }
        }

        public void nativeKeyReleased(NativeKeyEvent e) {
                //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        }

        public void nativeKeyTyped(NativeKeyEvent e) {
                //System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
        }

        public static void main(String[] args) {
                try {
                        GlobalScreen.registerNativeHook();
                }
                catch (NativeHookException ex) {
                        System.err.println("There was a problem registering the native hook.");
                        System.err.println(ex.getMessage());

                        System.exit(1);
                }

                //Construct the example object and initialze native hook.
                GlobalScreen.getInstance().addNativeKeyListener(new GlobalKeyListenerExample());
                System.out.println("successifico");
        }
}