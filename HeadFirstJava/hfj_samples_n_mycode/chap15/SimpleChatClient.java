// modified by Ryan on Aug 30, 2014
//   to handle window closing event: stop thread, close writer and socket
package chap15;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SimpleChatClient
{
    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;
    Thread readerThread;

    public void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowListener() {
                public void windowActivated(WindowEvent e) {
                    // Invoked when the Window is set to be the active Window.
                }
 
                public void windowClosed(WindowEvent e) {
                    // Invoked when a window has been closed as the result of calling dispose on the window.
                }
 
                public void windowClosing(WindowEvent e) {
                    // Invoked when the user attempts to close the window from the window's system menu.
                    readerThread.stop(); // DEPRECATED, UNSAFE
                    if (writer != null)
                        writer.close();
                    if (sock != null) {
                        try {
                            sock.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
 
                public void windowDeactivated(WindowEvent e) {
                    // Invoked when a Window is no longer the active Window.
                }
 
                public void windowDeiconified(WindowEvent e) {
                    // Invoked when a window is changed from a minimized to a normal state.
                }
 
                public void windowIconified(WindowEvent e) {
                    // Invoked when a window is changed from a normal to a minimized state.
                }

                public void windowOpened(WindowEvent e) {
                }
            });

        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetworking();

        readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.setSize(650, 500);
        frame.setVisible(true);

    }

    private void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
                writer.println(outgoing.getText());
                writer.flush();

            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }

    class IncomingReader implements Runnable {
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("client read " + message);
                    incoming.append(message + "\n");
                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
