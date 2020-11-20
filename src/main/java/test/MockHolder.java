package test;

import static org.mockito.Mockito.*;

public class MockHolder {
	private EmailService emailservice = mock(EmailService.class);

	public MockHolder() {
		Production.setEmailService(emailservice);
		Senario13.setEmailService(emailservice);

	}

	public EmailService getEmailService() {
		return emailservice;
	}
	public void setEmailService(EmailService emailservice) {
		this.emailservice=emailservice;
	}

}
