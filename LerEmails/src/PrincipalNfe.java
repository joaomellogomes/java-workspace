import javax.mail.MessagingException;

public class PrincipalNfe {

	public static void main(String[] args) {
		
//		@SuppressWarnings("unused")
		ReadEmails readMail = null;
		try {
			readMail = new ReadEmails();
			readMail.processMail();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
