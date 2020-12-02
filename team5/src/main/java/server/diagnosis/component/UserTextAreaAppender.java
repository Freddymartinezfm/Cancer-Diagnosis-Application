package server.diagnosis.component;

import java.util.logging.Level;

import javax.swing.JTextArea;

import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.logging.log4j.Logger;

public class UserTextAreaAppender extends WriterAppender {
	private JTextArea output;


	public UserTextAreaAppender(JTextArea output){
		this.output = output;
		// System.out.println("text field from UserTextAreaAppender" +  this.output.getText());




	}

	@Override
	public void append(LoggingEvent event) {

		if (event.getLevel().equals(Level.INFO)){
			this.output.append(event.getMessage().toString());
			this.output.setText(event.getMessage().toString());
			System.out.println("append called");

		}
	}

}